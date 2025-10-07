package com.model;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BillMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billno;
	@ManyToOne
	@JoinColumn(name="customerid",referencedColumnName = "customerid")
	private int customerid;
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(billno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillMaster other = (BillMaster) obj;
		return billno == other.billno;
	}
	@Override
	public String toString() {
		return "BillMaster [billno=" + billno + ", customerid=" + customerid + "]";
	}
}