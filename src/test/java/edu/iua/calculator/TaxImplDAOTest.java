package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.iua.calculator.dao.FactoryDAO;
import edu.iua.calculator.model.Tax;

public class TaxImplDAOTest {
	
    static int id;
    static Tax taxExpected;
	
	@BeforeAll
	static void setup() {
    	id = 2;
    	
    	taxExpected = new Tax();
    	
    	taxExpected.setTaxName("IIBB");
    	taxExpected.setTaxPercentage(0.03f);
	}
	
	@Test
	void findTaxByIdSuccess() {
		Tax taxObtained = (Tax) FactoryDAO.getInstance().getTaxDAO().findById(id);
		
		assertEquals(taxExpected.getTaxName(), taxObtained.getTaxName());
		assertEquals(taxExpected.getTaxPercentage(), taxObtained.getTaxPercentage());
    }
	
	@Test
	void findTaxByIdFail() {
		Tax taxObtained = (Tax) FactoryDAO.getInstance().getTaxDAO().findById(id);
		
		Tax taxMocked = new Tax();
		
    	taxMocked.setTaxName("AAA");
    	taxMocked.setTaxPercentage(0.0f);
		
		assertNotEquals(taxMocked.getTaxName(), taxObtained.getTaxName());
		assertNotEquals(taxMocked.getTaxPercentage(), taxObtained.getTaxPercentage());
    }

}