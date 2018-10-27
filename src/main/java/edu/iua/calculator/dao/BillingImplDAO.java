package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.Billing;
import edu.iua.calculator.model.HibernateUtil;

public class BillingImplDAO implements IGenericDAO<Billing, Integer> {

	private static BillingImplDAO instance;
	
	private BillingImplDAO() {}
	
	public static BillingImplDAO getInstance() {
		if (instance == null) {
			instance = new BillingImplDAO();
		}
		return instance;
	}

	public int save(Billing billing) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(billing);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return id;
	}

	public Billing findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Billing billing = null;
		
		try {
			tx = session.beginTransaction();
			billing = (Billing) session.get(Billing.class, id);
			
			if (billing == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el billing");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return billing;		
	}

	public List<Billing> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Billing> query = builder.createQuery(Billing.class);
            Root<Billing> from = query.from(Billing.class);

            query.select(from);
            
            List<Billing> resultListBillings = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListBillings;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(Billing billing) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Billing b = session.get(Billing.class, billing.getBillingId());

			if (b == null) {
				throw new RuntimeException();
			}

			billing.setAmount(billing.getAmount());
			billing.setDate(billing.getDate());

			session.update(billing);

			tx.commit();
			
			return billing.getBillingId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(Billing billing) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Billing b = session.get(Billing.class, billing.getBillingId());

			if (b == null) {
				throw new RuntimeException();
			}

			session.delete(b);

			tx.commit();

			return billing.getBillingId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}