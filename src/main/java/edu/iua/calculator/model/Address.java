package edu.iua.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	private int addressId;
	
	@Column(name = "street", length = 150, nullable = false)
	private String street;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "state", length = 100)
	private String state;

	@Column(name = "country", length = 100, nullable = false)
	private String country;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	public Address() {}
	
	public Address(String street, int number, String city, String state, String country, int zipCode) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Street: " + this.street + ", Number: " + this.number + ", City: " + this.city
				+ ", State: " + this.state + ", Country: " + this.country + ", ZipCode: " + this.zipCode;
	}
	
}