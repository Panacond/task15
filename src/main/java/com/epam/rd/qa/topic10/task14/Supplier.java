package com.epam.rd.qa.topic10.task14;

public class Supplier {

	private Integer customerID;

	private Integer yearOfBirth;

	private String streetOfResidence;

	public Supplier(Integer customerID, Integer yearOfBirth, String streetOfResidence) {
		this.customerID = customerID;
		this.yearOfBirth = yearOfBirth;
		this.streetOfResidence = streetOfResidence;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getStreetOfResidence() {
		return streetOfResidence;
	}

	public void setStreetOfResidence(String streetOfResidence) {
		this.streetOfResidence = streetOfResidence;
	}

	@Override
	public String toString() {
		return "Supplier{" +
				"customerID=" + customerID +
				", yearOfBirth=" + yearOfBirth +
				", streetOfResidence='" + streetOfResidence + '\'' +
				'}';
	}
}
