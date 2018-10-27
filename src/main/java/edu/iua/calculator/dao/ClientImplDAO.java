package edu.iua.calculator.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iua.calculator.model.Client;
import edu.iua.calculator.model.HibernateUtil;

public class ClientImplDAO implements IGenericDAO<Client, Integer> {

	private static ClientImplDAO instance;
	
	private ClientImplDAO() {}
	
	public static ClientImplDAO getInstance() {
		if (instance == null) {
			instance = new ClientImplDAO();
		}
		return instance;
	}

	public int save(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int id = 0;

		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(client);
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

	public Client findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Client client = null;
		
		try {
			tx = session.beginTransaction();
			client = (Client) session.get(Client.class, id);
			
			if (client == null) {
				throw new RuntimeException();
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un problema al buscar el client");
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return client;
	}

	public List<Client> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        
        try {
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Client> query = builder.createQuery(Client.class);
            Root<Client> from = query.from(Client.class);

            query.select(from);
            
            List<Client> resultListClients = session.createQuery(query).getResultList();

            tx.commit();
            
            return resultListClients;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return null;
	}

	public int update(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Client c = session.get(Client.class, client.getClientId());

			if (c == null) {
				throw new RuntimeException();
			}
			
			c.setName(client.getName());
			c.setLastName(client.getLastName());
			c.setIdentificationType(client.getIdentificationType());
			c.setAddress(client.getAddress());

			session.update(c);

			tx.commit();
			
			return client.getClientId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int delete(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Client c = session.get(Client.class, client.getClientId());

			if (c == null) {
				throw new RuntimeException();
			}

			session.delete(c);

			tx.commit();

			return client.getClientId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}