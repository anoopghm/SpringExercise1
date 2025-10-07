package com.encora.model.customermaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.encora.model.billmaster.BillMaster;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
 
@Entity
public class CustomerMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	private String cname;
	private String caddress;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<BillMaster>bills=new ArrayList<>();

	public List<BillMaster> getBills() {
		return bills;
	}
	public void setBills(List<BillMaster> bills) {
		this.bills = bills;
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getcAddress() {
		return caddress;
	}
	public void setcAddress(String caddress) {
		this.caddress = caddress;
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
		return "CustomerMaster [customerid=" + customerid + ", cname=" + cname + ", caddress=" + caddress + "]";
	}
	
}
