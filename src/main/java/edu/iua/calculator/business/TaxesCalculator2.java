package edu.iua.calculator.business;

import org.apache.log4j.Logger;

/**
 * Taxes Calculator returns a calculated total amount
 * based on taxes percentages
 */
public class TaxesCalculator2
{
    final static Logger logger = Logger.getLogger("TaxesCalculator2.class");

    public static void main( String[] args )
    {
        try {
//            System.out.print( "Enter amount value: " );
//
//            InputStreamReader isr = new InputStreamReader(System.in);
//            BufferedReader br = new BufferedReader (isr);
//
//            float amount = Float.parseFloat(br.readLine());
//            HashMap<String, Float> calculatedTax = calculate(amount);
//
//            Integer createdBill = saveBill(amount);
//            if (createdBill != null ){
//                System.out.println( "Bill with amount: "+ amount + " and id: " + createdBill + " has been created" );
//                logger.info("Bill with amount: "+ amount + " and id: " + createdBill + " has been created");
//            }
//
//            System.out.print( "Amount needs to be updated because it doesn't contains taxes." );
//            System.out.print( "Check value in database and then press Enter." );
//
//            br.readLine();
//
//
//            float totalAmount = amount;
//            for (String tax: calculatedTax.keySet()){
//                totalAmount += calculatedTax.get(tax);
//            }
//
//            Billing updatedBilling = updateBill(createdBill, totalAmount);
//            if (updatedBilling != null ){
//                System.out.println( "Billing with id: "+ createdBill + " has been updated to set this new amount: " + totalAmount );
//                logger.info("Billing with id: "+ createdBill + " has been updated to set this new amount: " + totalAmount);
//            }
//
//            System.out.print( "Check value in database and then press Enter." );
//
//            br.readLine();
//
//            System.out.println( "Get Bill!");
//            getBill();
//
//
//            System.out.print( "Deleting billing..." );
//            deleteBill(createdBill);
//            System.out.print( "- Billing has been deleted." );


            //BillingInfo billingInfo = new BillingInfo();
            //int clientId = billingInfo.saveClient();
            //System.out.println( "Client has been created with id: "+ clientId );

//            getClients();
//
//            getClientByName("Ivan");
//            getClientsByIdentificationType("DNI-PRUEBA");
//            getBillingsByAmountBetween(2000f, 4000f);

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

//            System.out.println("Fecha en String: " + dateFormat.format(new java.util.Date().getTime()));
//

//            isr.close();
        	
			// Test Address Entity
			
//			Address address = new Address();
//			address.setStreet("Fuerza Aerea Argentina");
//			address.setNumber(6500);
//			address.setCity("Cordoba");
//			address.setState("Cordoba");
//			address.setCountry("Argentina");
//			address.setZipCode(5000);
//			
////			// Save Address
//			int addressId = testSaveAddress(address);
//			System.out.printf("Address with id = %d was created succesfully.", addressId);

//			Update Address
//			address.setStreet("Av. Colon");
//			address.setNumber(1535);
//			
//			testUpdateAddress(addressId, address);
//			System.out.printf("Address with id = %d was updated succesfully.", addressId);
//
//			Delete Address
//			testDeleteAddress(addressId);
//			System.out.printf("Address with id = %d was deleted succesfully.", addressId);
			

// 			Test Identification Type Entity
			
// 			Save Identification Type
			
//			IdentificationType type = new IdentificationType("DNI");
//			int ITypeId = testSaveIType(type);
//			System.out.printf("Identification Type with id = %d was created succesfully.", ITypeId);

//			IdentificationType type = new IdentificationType("DNI-PRUEBA");
//			int ITypeId = testSaveIType(type);
//			System.out.printf("Identification Type with id = %d was created succesfully.", ITypeId);

//			Update Identification Type
//			type.setIdentificationType("CI");
//			testUpdateIType(ITypeId, type);
//			System.out.printf("Identification Type with id = %d was updated succesfully.", ITypeId);
//
//			Delete Identification Type
//			testDeleteIType(ITypeId);
//			System.out.printf("Identification Type with id = %d was deleted succesfully.", ITypeId);
			
			
			
			// Test Client Entity
//			
//			Address address = new Address();
//			address.setAddressId(1);
//			
//			IdentificationType type = new IdentificationType();
//			type.setIdentificationId(1);
//			
//			// Save Client
//			Client client = new Client();
//			client.setName("Ivan");
//			client.setLastName("Guerra");
//			client.setAddress(address);
//			client.setIdentificationType(type);
//			
//			int clientId = testSaveClient(client);
//			System.out.printf("Client with id = %d was created succesfully.", clientId);
//			
//			Client client2 = new Client();
//			client2.setName("Claudio");
//			client2.setLastName("Lopez");
//			client2.setAddress(address);
//			client2.setIdentificationType(type);
//			
//			int client2Id = testSaveClient(client2);
//			System.out.printf("Client with id = %d was created succesfully.", client2Id);
//
//			Client client3 = new Client();
//			client3.setName("Pedro");
//			client3.setLastName("Martinez");
//			client3.setAddress(address);
//			client3.setIdentificationType(type);
//			
//			int client3Id = testSaveClient(client3);
//			System.out.printf("Client with id = %d was created succesfully.", client3Id);
//
//			Client client4 = new Client();
//			client4.setName("Juan");
//			client4.setLastName("Perez");
//			client4.setAddress(address);
//			client4.setIdentificationType(type);
//			
//			int client4Id = testSaveClient(client4);
//			System.out.printf("Client with id = %d was created succesfully.", client4Id);
//			
//			
//			//
//			
//			
//			Client client5 = new Client();
//			client5.setName("Agustina");
//			client5.setLastName("Sosa");
//			client5.setAddress(address);
//			
//			int client5Id = testSaveClient(client5);
//			System.out.printf("Client with id = %d was created succesfully.", client5Id);
//			
//			Client client6 = new Client();
//			client6.setName("Maria");
//			client6.setLastName("Guzman");
//			client6.setAddress(address);
//			
//			int client6Id = testSaveClient(client6);
//			System.out.printf("Client with id = %d was created succesfully.", client6Id);
//
//			Client client7 = new Client();
//			client7.setName("Camila");
//			client7.setLastName("Herrera");
//			client7.setAddress(address);
//			
//			int client7Id = testSaveClient(client7);
//			System.out.printf("Client with id = %d was created succesfully.", client7Id);

			//
			
//			Update Client
//			client.setName("Pedro");
//			testUpdateClient(clientId, client);
//			System.out.printf("Client with id = %d was updated succesfully.", clientId);

//			Delete Client
//			testDeleteClient(clientId);
//			System.out.printf("Client with id = %d was deleted succesfully.", clientId);

			

//			Billing billing2 = new Billing();
//			billing2.setAmount(2400f);
//			billing2.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing2Id = testSaveBilling(billing2);
//			System.out.printf("Billing with id = %d was created succesfully.", billing2Id);
//
//			Billing billing3 = new Billing();
//			billing3.setAmount(2500f);
//			billing3.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing3Id = testSaveBilling(billing3);
//			System.out.printf("Billing with id = %d was created succesfully.", billing3Id);
//
//			Billing billing4 = new Billing();
//			billing4.setAmount(4000f);
//			billing4.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing4Id = testSaveBilling(billing4);
//			System.out.printf("Billing with id = %d was created succesfully.", billing4Id);
//
//			Billing billing5 = new Billing();
//			billing5.setAmount(1000f);
//			billing5.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing5Id = testSaveBilling(billing5);
//			System.out.printf("Billing with id = %d was created succesfully.", billing5Id);
//
//			Billing billing6 = new Billing();
//			billing6.setAmount(5000f);
//			billing6.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing6Id = testSaveBilling(billing6);
//			System.out.printf("Billing with id = %d was created succesfully.", billing6Id);
//
//			Billing billing7 = new Billing();
//			billing7.setAmount(6450f);
//			billing7.setDate(new Date(new java.util.Date().getTime()));
//			
//			int billing7Id = testSaveBilling(billing7);
//			System.out.printf("Billing with id = %d was created succesfully.", billing7Id);
//
//			
//			Update Billing

//			Delete Billing
        	

//        } catch (IOException e) {
//            System.out.println( "Sorry, an error has occurred. Please try again!" );
//            logger.error("Sorry, an error has occurred. Please try again!", e);
        } catch (NumberFormatException e) {
            System.out.println( "Invalid amount value. Please try again!" );
            logger.error("Invalid amount value. Please try again!", e);
        }

    }

}
