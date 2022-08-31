package com.epam.rd.qa.topic10.task14;

import java.util.Objects;

public class DiscountOwner extends Supplier{
	
	private String storeName;
	
	private Supplier supplier;

	public DiscountOwner(String storeName, Supplier supplier) {
		super(supplier.getCustomerID(), supplier.getYearOfBirth(), supplier.getStreetOfResidence());
		this.storeName = storeName;
		this.supplier = supplier;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "\nDiscountOwner{" +
				"storeName='" + storeName + '\'' +
				", supplier=" + supplier +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DiscountOwner that = (DiscountOwner) o;
		return Objects.equals(storeName, that.storeName) && Objects.equals(supplier, that.supplier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(storeName, supplier);
	}
}
