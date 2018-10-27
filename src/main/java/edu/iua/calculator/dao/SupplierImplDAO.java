package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.HibernateUtil;
import edu.iua.calculator.model.Supplier;

public class SupplierImplDAO implements IGenericDAO<Supplier, Integer> {

	private static SupplierImplDAO instance;
	
	private SupplierImplDAO() {}
	
	public static SupplierImplDAO getInstance() {
		if (instance == null) {
			instance = new SupplierImplDAO();
		}
		return instance;
	}

	public int save(Supplier supplier) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(supplier);
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

	public Supplier findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Supplier supplier = null;
		
		try {
			tx = session.beginTransaction();
			supplier = (Supplier) session.get(Supplier.class, id);
			
			if (supplier == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el supplier");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return supplier;
	}

	public List<Supplier> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Supplier> query = builder.createQuery(Supplier.class);
            Root<Supplier> from = query.from(Supplier.class);

            query.select(from);
            
            List<Supplier> resultListSuppliers = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListSuppliers;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(Supplier supplier) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Supplier s = session.get(Supplier.class, supplier.getSupplierId());

			if (s == null) {
				throw new RuntimeException();
			}

			s.setBusinessName(supplier.getBusinessName());

			session.update(s);

			tx.commit();
			
			return supplier.getSupplierId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(Supplier supplier) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Supplier s = session.get(Supplier.class, supplier.getSupplierId());

			if (s == null) {
				throw new RuntimeException();
			}

			session.delete(s);

			tx.commit();

			return supplier.getSupplierId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}