package com.encora.model.compkey;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompKey implements Serializable{
	
	private int billno;
	private int itemno;
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	
}