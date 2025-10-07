package com.model;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CustomerMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	private String customername;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMaster other = (CustomerMaster) obj;
		return customerid == other.customerid;
	}
	@Override
	public String toString() {
		return "CustomerMaster [customerid=" + customerid + ", customername=" + customername + "]";
	}
}