package edu.iua.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.iua.calculator.dao.FactoryDAO;
import edu.iua.calculator.model.Address;
import edu.iua.calculator.model.Client;
import edu.iua.calculator.model.IdentificationType;

public class ClientImplDAOTest {
	
	static int id;
	static Client clientExpected;
	
	@BeforeAll
	static void setup() {
		id = 2;
		
		clientExpected = new Client();

		clientExpected.setName("Claudio");
		clientExpected.setLastName("Lopez");
	
		Address address = new Address();
		address.setAddressId(1);
		
		clientExpected.setAddress(address);

		IdentificationType type = new IdentificationType();
		type.setIdentificationId(1);
		
		clientExpected.setIdentificationType(type);
	}
	
	@Test
	void findClientByIdSuccess() {
		Client clientObtained = (Client) FactoryDAO.getInstance().getClientDAO().findById(id);
		
		assertEquals(clientExpected.getName(), clientObtained.getName());
		assertEquals(clientExpected.getLastName(), clientObtained.getLastName());
		assertEquals(clientExpected.getAddress().getAddressId(), clientObtained.getAddress().getAddressId());
		assertEquals(clientExpected.getIdentificationType().getIdentificationId(), clientObtained.getIdentificationType().getIdentificationId());
	}
	
	@Test
	void findClientByIdFail() {
		Client clientObtained = (Client) FactoryDAO.getInstance().getClientDAO().findById(id);
		
		Client clientMocked = new Client();
		clientMocked.setName("Pepe");
		clientMocked.setLastName("Argento");

		Address addressMocked = new Address();
		addressMocked.setAddressId(0);
		
		clientMocked.setAddress(addressMocked);

		IdentificationType typeMocked = new IdentificationType();
		typeMocked.setIdentificationId(0);
		
		clientMocked.setIdentificationType(typeMocked);
		
		assertNotEquals(clientMocked.getName(), clientObtained.getName());
		assertNotEquals(clientMocked.getLastName(), clientObtained.getLastName());
		assertNotEquals(clientMocked.getAddress().getAddressId(), clientObtained.getAddress().getAddressId());
		assertNotEquals(clientMocked.getIdentificationType().getIdentificationId(), clientObtained.getIdentificationType().getIdentificationId());
	}
	
}