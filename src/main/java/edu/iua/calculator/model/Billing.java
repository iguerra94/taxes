package edu.iua.calculator.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billing_details")
public class Billing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="billing_id", nullable = false)
	private int billingId;

	@Column(name="amount", precision = 3, nullable = false)
	private Float amount;
	
	@Column(name="date", nullable = false)
	private Date date;
	
	public Billing() {}

	public Billing(Float amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Amount: " + this.amount + ", Date: " + this.date;
	}

}
