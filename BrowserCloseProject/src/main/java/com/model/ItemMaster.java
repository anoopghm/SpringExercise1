package com.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMaster{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int itemid;
	 private String itemdesc;
	 private float itemprice;
	 private int shopno;
	 
	 public int getItemid() {
		return itemid;
	}
	 public void setItemid(int itemid) {
		 this.itemid = itemid;
	 }
	 public String getItemdesc() {
		 return itemdesc;
	 }
	 public void setItemdesc(String itemdesc) {
		 this.itemdesc = itemdesc;
	 }
	 public float getItemprice() {
		 return itemprice;
	 }
	 public void setItemprice(float itemprice) {
		 this.itemprice = itemprice;
	 }
	 public int getShopno() {
		 return shopno;
	 }
	 public void setShopno(int shopno) {
		 this.shopno = shopno;
	 }
	 @Override
	 public int hashCode() {
		return Objects.hash(itemid);
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
		return itemid == other.itemid;
	 }
	 
}