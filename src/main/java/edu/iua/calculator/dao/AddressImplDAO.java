package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.Address;
import edu.iua.calculator.model.HibernateUtil;

public class AddressImplDAO implements IGenericDAO<Address, Integer>{

	private static AddressImplDAO instance;
	
	private AddressImplDAO() {}
	
	public static AddressImplDAO getInstance() {
		if (instance == null) {
			instance = new AddressImplDAO();
		}
		return instance;
	}

	public int save(Address address) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(address);
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

	public Address findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Address address = null;
		
		try {
			tx = session.beginTransaction();
			address = (Address) session.get(Address.class, id);
			
			if (address == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el address");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return address;
	}

	public List<Address> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Address> query = builder.createQuery(Address.class);
            Root<Address> from = query.from(Address.class);

            query.select(from);
            
            List<Address> resultListAddresses = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListAddresses;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(Address address) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Address a = session.get(Address.class, address.getAddressId());

			if (a == null) {
				throw new RuntimeException();
			}
			
			a.setStreet(address.getStreet());
			a.setNumber(address.getNumber());
			a.setCity(address.getCity());
			a.setState(address.getState());
			a.setCountry(address.getCountry());
			a.setZipCode(address.getZipCode());
			
			session.update(a);

			tx.commit();
			
			return address.getAddressId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(Address address) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Address a = session.get(Address.class, address.getAddressId());

			if (a == null) {
				throw new RuntimeException();
			}

			session.delete(a);

			tx.commit();

			return address.getAddressId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}