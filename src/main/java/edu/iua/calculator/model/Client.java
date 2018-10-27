package edu.iua.calculator.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id", nullable = false)
	private int clientId;
	
	@Column(name="name", length = 60, nullable = false)
	private String name;

	@Column(name="last_name", length = 60, nullable = false)
	private String lastName;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "identification_id")
	private IdentificationType identificationType;

	public Client() {}

	public Client(String name, String lastName, Address address, IdentificationType identificationType) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.identificationType = identificationType;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public IdentificationType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", LastName: " + this.lastName + ", Address: (" + this.address + "), IdentificationType: (" + this.identificationType + ")";
	}

	
}