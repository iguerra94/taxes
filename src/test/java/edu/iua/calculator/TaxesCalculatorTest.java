package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.iua.calculator.business.TaxesCalculator;
import edu.iua.calculator.model.Billing;
import edu.iua.calculator.model.Client;

public class TaxesCalculatorTest {

    static Map<String, String> hashMapClientsExpected;
    static Map<String, Billing> hashMapBillingsExpected;
    static Billing billingExpected;
    static SimpleDateFormat dateFormat;
    static int id;
    static int idIncremental = 18;

    @BeforeAll
    static void setUp(){
    	hashMapClientsExpected = new HashMap<String, String>();
    	hashMapClientsExpected.put("name_1", "Ivan");
    	hashMapClientsExpected.put("last_name_1", "Guerra");
    	hashMapClientsExpected.put("name_2", "Claudio");
    	hashMapClientsExpected.put("last_name_2", "Lopez");

    	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	
    	id = 4;
    	
    	try {
        	hashMapBillingsExpected = new HashMap<String, Billing>();

        	hashMapBillingsExpected.put("billing_1", new Billing(2400f, new Date(dateFormat.parse("2018-10-10").getTime())));
	    	hashMapBillingsExpected.put("billing_2", new Billing(2500f, new Date(dateFormat.parse("2018-10-10").getTime())));
	    	hashMapBillingsExpected.put("billing_3", new Billing(4000f, new Date(dateFormat.parse("2018-10-10").getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	try {
			billingExpected = new Billing(4000f, new Date(dateFormat.parse("2018-10-10").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    @Test
    void getClientsByNameSuccess() {
        List<Client> resultList = TaxesCalculator.getClientByName("Ivan");
 
        assertEquals(resultList.get(0).getName(), hashMapClientsExpected.get("name_1"));
        assertEquals(resultList.get(0).getLastName(), hashMapClientsExpected.get("last_name_1"));
    }
   
    @Test
    void getClientsByIdentificationTypeSuccess() {
        List<Client> resultList = TaxesCalculator.getClientsByIdentificationType("DNI-PRUEBA");

        assertEquals(resultList.get(0).getName(), hashMapClientsExpected.get("name_1"));
        assertEquals(resultList.get(0).getLastName(), hashMapClientsExpected.get("last_name_1"));
        assertEquals(resultList.get(1).getName(), hashMapClientsExpected.get("name_2"));
        assertEquals(resultList.get(1).getLastName(), hashMapClientsExpected.get("last_name_2"));
    }

    @Test
    void getClientsByIdentificationTypeFail() {
        List<Client> resultList = TaxesCalculator.getClientsByIdentificationType("DNI-PRUEBA");
        HashMap<String, String> hashMapExpected = new HashMap<String, String>();
        hashMapExpected.put("name_1", "Pepe");
        hashMapExpected.put("last_name_1", "Argento");

        assertNotEquals(resultList.get(0).getName(), hashMapExpected.get("name_1"));
        assertNotEquals(resultList.get(0).getLastName(), hashMapExpected.get("last_name_1"));
    }
    
    @Test
    void getBillingsByAmountBetweenSuccess() {
        List<Billing> resultList = TaxesCalculator.getBillingsByAmountBetween(2000f, 4000f);

        assertEquals(resultList.get(0).getAmount(), hashMapBillingsExpected.get("billing_1").getAmount());
        assertEquals(
        		dateFormat.format(resultList.get(0).getDate()), 
        		dateFormat.format(hashMapBillingsExpected.get("billing_1").getDate()));
        
        assertEquals(resultList.get(1).getAmount(), hashMapBillingsExpected.get("billing_2").getAmount());
        assertEquals(
        		dateFormat.format(resultList.get(1).getDate()), 
        		dateFormat.format(hashMapBillingsExpected.get("billing_2").getDate()));
        
        assertEquals(resultList.get(2).getAmount(), hashMapBillingsExpected.get("billing_3").getAmount());
        assertEquals(
        		dateFormat.format(resultList.get(2).getDate()), 
        		dateFormat.format(hashMapBillingsExpected.get("billing_3").getDate()));
    }
   
}