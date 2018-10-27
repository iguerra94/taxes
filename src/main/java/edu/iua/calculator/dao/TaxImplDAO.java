package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.HibernateUtil;
import edu.iua.calculator.model.Tax;

public class TaxImplDAO implements IGenericDAO<Tax, Integer> {

	private static TaxImplDAO instance;
	
	private TaxImplDAO() {}
	
	public static TaxImplDAO getInstance() {
		if (instance == null) {
			instance = new TaxImplDAO();
		}
		return instance;
	}

	public int save(Tax tax) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(tax);
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

	public Tax findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Tax tax = null;
		
		try {
			tx = session.beginTransaction();
			tax = (Tax) session.get(Tax.class, id);
			
			if (tax == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el tax");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return tax;
	}

	public List<Tax> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Tax> query = builder.createQuery(Tax.class);
            Root<Tax> from = query.from(Tax.class);

            query.select(from);
            
            List<Tax> resultListTaxes = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListTaxes;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(Tax tax) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Tax t = session.get(Tax.class, tax.getTaxId());

			if (t == null) {
				throw new RuntimeException();
			}

			t.setTaxName(tax.getTaxName());
			t.setTaxPercentage(tax.getTaxPercentage());
			
			session.update(t);

			tx.commit();
			
			return tax.getTaxId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(Tax tax) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Tax t = session.get(Tax.class, tax.getTaxId());

			if (t == null) {
				throw new RuntimeException();
			}

			session.delete(t);

			tx.commit();

			return tax.getTaxId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}