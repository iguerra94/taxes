package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.iua.calculator.dao.FactoryDAO;
import edu.iua.calculator.model.Address;

public class AddressImplDAOTest {

	static int id;
	static Address addressExpected;
	
	@BeforeAll
	static void setup() {
		id = 1;
		
		addressExpected = new Address();
		
		addressExpected.setCity("Cordoba");
		addressExpected.setCountry("Argentina");
		addressExpected.setNumber(6500);
		addressExpected.setState("Cordoba");
		addressExpected.setStreet("Fuerza Aerea Argentina");
		addressExpected.setZipCode(5000);
	}
	
	@Test
	void findAddressByIdSuccess() {
		Address addressObtained = (Address) FactoryDAO.getInstance().getAddressDAO().findById(id);
		
		assertEquals(addressExpected.getCity(), addressObtained.getCity());
		assertEquals(addressExpected.getCountry(), addressObtained.getCountry());
		assertEquals(addressExpected.getNumber(), addressObtained.getNumber());
		assertEquals(addressExpected.getState(), addressObtained.getState());
		assertEquals(addressExpected.getStreet(), addressObtained.getStreet());
		assertEquals(addressExpected.getZipCode(), addressObtained.getZipCode());
	}
	
	@Test
	void findAddressByIdFail() {
		Address addressObtained = (Address) FactoryDAO.getInstance().getAddressDAO().findById(id);
		
		Address addressMocked = new Address();
		
		addressMocked.setCity("AAA");
		addressMocked.setCountry("AAA");
		addressMocked.setNumber(0);
		addressMocked.setState("AAA");
		addressMocked.setStreet("AAA");
		addressMocked.setZipCode(0);
		
		assertNotEquals(addressMocked.getCity(), addressObtained.getCity());
		assertNotEquals(addressMocked.getCountry(), addressObtained.getCountry());
		assertNotEquals(addressMocked.getNumber(), addressObtained.getNumber());
		assertNotEquals(addressMocked.getState(), addressObtained.getState());
		assertNotEquals(addressMocked.getStreet(), addressObtained.getStreet());
		assertNotEquals(addressMocked.getZipCode(), addressObtained.getZipCode());
	}
	
}