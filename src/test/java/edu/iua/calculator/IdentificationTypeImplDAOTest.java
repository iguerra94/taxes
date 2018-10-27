package edu.iua.calculator;

import edu.iua.calculator.dao.FactoryDAO;
import edu.iua.calculator.model.IdentificationType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IdentificationTypeImplDAOTest {
	
    static int id;
    static IdentificationType identificationTypeExpected;
	
	@BeforeAll
	static void setup() {
    	id = 1;

    	identificationTypeExpected = new IdentificationType();
    	
    	identificationTypeExpected.setIdentificationType("DNI-PRUEBA");
	}
	
	@Test
	void findIdentificationTypeByIdSuccess() {
		IdentificationType identificationTypeObtained = (IdentificationType) FactoryDAO.getInstance().getIdentificationTypeDAO().findById(id);
		
		assertEquals(
				identificationTypeExpected.getIdentificationType(), 
				identificationTypeObtained.getIdentificationType());
    }
	
	@Test
	void findIdentificationTypeByIdFail() {
		IdentificationType identificationTypeObtained = (IdentificationType) FactoryDAO.getInstance().getIdentificationTypeDAO().findById(id);

		IdentificationType identificationTypeMocked = new IdentificationType();
    	
    	identificationTypeMocked.setIdentificationType("DNI-FALSO");
	
    	assertNotEquals(
    			identificationTypeMocked.getIdentificationType(), 
    			identificationTypeObtained.getIdentificationType());
	}

}