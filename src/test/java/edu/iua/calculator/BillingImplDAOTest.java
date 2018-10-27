package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.iua.calculator.dao.FactoryDAO;
import edu.iua.calculator.model.Billing;

public class BillingImplDAOTest {
	
    static SimpleDateFormat dateFormat;
    static int id;
    static Billing billingExpected;
	
	@BeforeAll
	static void setup() {
    	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	id = 4;
    	
		try {
			billingExpected = new Billing(4000f, new Date(dateFormat.parse("2018-10-10").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
    @Test
    void findBillingByIdSuccess() {
    	Billing billingObtained = (Billing) FactoryDAO.getInstance().getBillingDAO().findById(id);
    
    	assertEquals(billingExpected.getAmount(), billingObtained.getAmount());
    	assertEquals(
        		dateFormat.format(billingExpected.getDate()), 
        		dateFormat.format(billingObtained.getDate()));
    }
    
    @Test
    void findBillingByIdFail() {
    	Billing billingObtained = (Billing) FactoryDAO.getInstance().getBillingDAO().findById(id);
    	Billing billingMocked = null;

    	try {
			billingMocked = new Billing(1000f, new Date(dateFormat.parse("2018-10-13").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	assertNotEquals(billingMocked.getAmount(), billingObtained.getAmount());
    	assertNotEquals(
        		dateFormat.format(billingMocked.getDate()), 
        		dateFormat.format(billingObtained.getDate()));
    }

}