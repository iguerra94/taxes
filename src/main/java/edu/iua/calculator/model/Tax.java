package edu.iua.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxes_details")
public class Tax {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	private int taxId;
	
	@Column(name="tax_name", length = 60, nullable = false)
	private String taxName;

	@Column(name="tax_percentage", precision = 3, nullable = false)
	private Float taxPercentage;

	public Tax() {}

	public Tax(String taxName, Float taxPercentage) {
		super();
		this.taxName = taxName;
		this.taxPercentage = taxPercentage;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public Float getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(Float taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Override
	public String toString() {
		return "TaxName: " + this.taxName + ", TaxPercentage: " + this.taxPercentage;
	}
	
}