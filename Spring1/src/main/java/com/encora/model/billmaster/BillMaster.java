package com.encora.model.billmaster;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillMaster implements Comparable<BillMaster>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billno;
	private Date date;
	@ManyToOne
	@JoinColumn(name="customerid",referencedColumnName = "customerid")
	private int customerid;
	public int getCustomer() {
		return customerid;
	}
	public void setCustomer(int customerid) {
		this.customerid = customerid;
	}

	private float discount;
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
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
		return "BillMaster [billno=" + billno + ", date=" + date + ", customer=" + customerid + ", discount=" + discount
				+ "]";
	}
	public int compareTo(BillMaster b) {
		return Integer.compare(this.billno, b.billno);
	}
	
} 
