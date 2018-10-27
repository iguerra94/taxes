package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.HibernateUtil;
import edu.iua.calculator.model.IdentificationType;

public class IdentificationTypeImplDAO implements IGenericDAO<IdentificationType, Integer> {

	private static IdentificationTypeImplDAO instance;
	
	private IdentificationTypeImplDAO() {}
	
	public static IdentificationTypeImplDAO getInstance() {
		if (instance == null) {
			instance = new IdentificationTypeImplDAO();
		}
		return instance;
	}

	public int save(IdentificationType identificationType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(identificationType);
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

	public IdentificationType findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		IdentificationType identificationType = null;
		
		try {
			tx = session.beginTransaction();
			identificationType = (IdentificationType) session.get(IdentificationType.class, id);
			
			if (identificationType == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el identification type");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
		return identificationType;
	}

	public List<IdentificationType> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<IdentificationType> query = builder.createQuery(IdentificationType.class);
            Root<IdentificationType> from = query.from(IdentificationType.class);

            query.select(from);
            
            List<IdentificationType> resultListIdentificationTypes = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListIdentificationTypes;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(IdentificationType identificationType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			IdentificationType type = session.get(IdentificationType.class, identificationType.getIdentificationId());

			if (type == null) {
				throw new RuntimeException();
			}
			
			type.setIdentificationType(identificationType.getIdentificationType());
			
			session.update(type);

			tx.commit();
			
			return identificationType.getIdentificationId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(IdentificationType identificationType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			IdentificationType type = session.get(IdentificationType.class, identificationType.getIdentificationId());

			if (type == null) {
				throw new RuntimeException();
			}

			session.delete(type);

			tx.commit();

			return identificationType.getIdentificationId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}