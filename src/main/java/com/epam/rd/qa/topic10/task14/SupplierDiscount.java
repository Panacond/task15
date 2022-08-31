package com.epam.rd.qa.topic10.task14;

import java.util.Objects;

public class SupplierDiscount {

	private Integer customerID;

	private Integer discountPercentage;

	private String storeName;

	public SupplierDiscount(Integer customerID, Integer discountPercentage, String storeName) {
		this.customerID = customerID;
		this.discountPercentage = discountPercentage;
		this.storeName = storeName;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SupplierDiscount that = (SupplierDiscount) o;
		return Objects.equals(customerID, that.customerID) && Objects.equals(discountPercentage, that.discountPercentage) && Objects.equals(storeName, that.storeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, discountPercentage, storeName);
	}

	@Override
	public String toString() {
		return "SupplierDiscount{" +
				"customerID=" + customerID +
				", discountPercentage=" + discountPercentage +
				", storeName='" + storeName + '\'' +
				'}';
	}
}