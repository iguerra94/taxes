package edu.iua.calculator.business;

import edu.iua.calculator.model.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Taxes Calculator returns a calculated total amount based on taxes percentages
 */
public class TaxesCalculator {
	final static Logger logger = Logger.getLogger(TaxesCalculator.class);
	
	public static void main(String[] args) {
		System.out.print("Enter amount value: ");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
//			float amount = Float.parseFloat(br.readLine());
//			HashMap<String, Float> calculatedTax = calculate(amount);
//
//			JSONObject jo = new JSONObject(calculatedTax);
//			System.out.println(jo);
			
			
// 			Test Billing Entity
			
// 			Save Billing
//			Billing billing = new Billing();
//			billing.setAmount(1510f);
//			billing.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billingId = FactoryDAO.getInstance().getBillingDAO().save(billing);
//		
//			System.out.printf("Billing with id = %d was created succesfully.", billingId);


//			List<Billing> billings = FactoryDAO.getInstance().getBillingDAO().findAll();
//			
//			for (Billing billing : billings) {
//				System.out.println("Billing: " + billing);
//			}
//			
			
//			int id = 1;
//
//			Billing billing2 = (Billing) FactoryDAO.getInstance().getBillingDAO().findById(id);
//			System.out.printf("Billing with id = %d: %s", id, billing2.toString());
//
//			billing2.setAmount(3000f);
//			billing2.setDate(new Date(new java.util.Date().getTime()));
//
//			int id_billing_updated = FactoryDAO.getInstance().getBillingDAO().update(billing2);
//			System.out.printf("Billing with id = %d was updated successfully", id_billing_updated);
//
//			int id_billing_deleted = FactoryDAO.getInstance().getBillingDAO().delete(billing2);
//			System.out.printf("Billing with id = %d was deleted successfully", id_billing_deleted);
//

//		} catch (IOException e) {
//			System.out.println("Sorry, an error has occurred. Please try again!");
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount value. Please try again!");
		}

	}

	public static HashMap<String, Float> calculate(float amount) {
		HashMap<String, Float> calculatedTaxesAmount = new HashMap<String, Float>();

		Tax taxes = new Tax();
		HashMap<String, Float> taxesPercentages = getTaxesPercentage();

		float totalAmount = amount;
		
		for (String tax : taxesPercentages.keySet()) {
			float taxValue = taxesPercentages.get(tax);
			float applicableTax = amount * taxValue;
			calculatedTaxesAmount.put(tax, applicableTax);
			totalAmount = totalAmount + applicableTax;
		}

		return calculatedTaxesAmount;
	}

	private static HashMap<String, Float> getTaxesPercentage() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		HashMap<String, Float> taxesPercentage = new HashMap<String, Float>();

		try {
			tx = session.beginTransaction();
			List taxes = session.createQuery("FROM Tax").list();

			for (Iterator iterator = taxes.iterator(); iterator.hasNext();) {
				Tax tax = (Tax) iterator.next();
				taxesPercentage.put(tax.getTaxName(), tax.getTaxPercentage());
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		return taxesPercentage;
	}
	

    public static List<Client> getClientByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;

        List<Client> resultListClients = null;
        
        try {

            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();


            CriteriaQuery<Client> query = builder.createQuery(Client.class);
            Root<Client> from = query.from(Client.class);

            query.select(from).where(builder.equal(from.get("name"), name));
            resultListClients = session.createQuery(query).getResultList();
//            System.out.println("CLIENTS LIST : " + resultListClients.toString());

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return resultListClients;
    }

    //  Método que traiga todas las facturas cuyos montos se encuentran entre determinados valores (mínimos y máximos) 
    public static List<Billing> getBillingsByAmountBetween(Float amountMin, Float amountMax){
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;

        List<Billing> resultListBillings = null;
        
        try {

        	// Select amount, date
        	// from Billings
        	// where amount between ? and ?
        	
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();


            CriteriaQuery<Billing> query = builder.createQuery(Billing.class);
            Root<Billing> from = query.from(Billing.class);
            
            Predicate minMaxAmount = builder.between(from.get("amount").as(Float.class), amountMin, amountMax);
            
            query.select(from).where(minMaxAmount);

            resultListBillings = session.createQuery(query).getResultList();
//            System.out.println("BILLINGS LIST : " + resultListBillings.toString());

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultListBillings;
    }
    
    //  Metodo que busque todos los clientes con un determinado identificationType.
    public static List<Client> getClientsByIdentificationType(String identificationType){
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;

        List<Client> resultListClients = null;
        
        try {

        	// Select name, lastName, identificationType 
        	// from Client c inner join IdentificationType it on c.identificationId = it.identificationId
        	// where identificationType = ?
        	
            tx = session.beginTransaction();

            session.flush();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Client> query = builder.createQuery(Client.class);
            
            Root<Client> from = query.from(Client.class);
            Join<Client, IdentificationType> join = from.join("identificationType", JoinType.INNER);
            
            Predicate identificationTypeEqualTo = builder.equal(join.get("identificationType"), identificationType);
            
            query.select(from).where(identificationTypeEqualTo);

            resultListClients = session.createQuery(query).getResultList();
//            System.out.println("CLIENTS LIST : " + resultListClients.toString());

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultListClients;
    }
	
}