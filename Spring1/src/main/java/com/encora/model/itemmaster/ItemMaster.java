package com.encora.model.itemmaster;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemno;
	private String itemdesc;
	private int customerid;
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMaster other = (ItemMaster) obj;
		return itemno == other.itemno;
	}
	@Override
	public String toString() {
		return "ItemMaster [itemno=" + itemno + ", itemdesc=" + itemdesc + ", customerid=" + customerid + "]";
	}
}
