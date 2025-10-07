package com.model;

import java.util.Objects;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemTransaction implements Comparable<ItemTransaction> {
	@EmbeddedId
	private CompKey mykey;
	private int qty;
	public CompKey getMykey() {
		return mykey;
	}
	public void setMykey(CompKey mykey) {
		this.mykey = mykey;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mykey);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemTransaction other = (ItemTransaction) obj;
		return Objects.equals(mykey, other.mykey);
	}
	public int compareTo(ItemTransaction o) {
	     int compareBill = Integer.compare(o.mykey.getBillno(), this.mykey.getBillno());
	     int compareItem = Integer.compare(o.mykey.getItemno(), this.mykey.getItemno());
	     int result = compareBill & compareItem;
	     return result;
	}
}