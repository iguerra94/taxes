package edu.iua.calculator.dao;

public class FactoryDAO {

	private static FactoryDAO instance;
	
	private FactoryDAO() {}
	
	public static FactoryDAO getInstance() {
		if (instance == null) {
			instance = new FactoryDAO();
		}
		return instance;
	}
	
	private static String dbActive = "MYSQL";
	
	public static IGenericDAO getBillingDAO() {
		if (dbActive == "MYSQL") {
			return BillingImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}
	
	public static IGenericDAO getClientDAO() {
		if (dbActive == "MYSQL") {
			return ClientImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}
	
	public static IGenericDAO getAddressDAO() {
		if (dbActive == "MYSQL") {
			return AddressImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}

	public static IGenericDAO getIdentificationTypeDAO() {
		if (dbActive == "MYSQL") {
			return IdentificationTypeImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}

	public static IGenericDAO getSupplierDAO() {
		if (dbActive == "MYSQL") {
			return SupplierImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}

	public static IGenericDAO getTaxDAO() {
		if (dbActive == "MYSQL") {
			return TaxImplDAO.getInstance();
		} 
//		else {
//			return BillingOracleDAO.getInstance();
//		}
		return null;
	}
}