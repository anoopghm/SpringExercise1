package com.model;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ItemMaster{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int itemid;
	 private float itemdesc;
	 private float itemprice;
	 public int getItemid() {
		 return itemid;
	 }
	 public void setItemid(int itemid) {
		 this.itemid = itemid;
	 }
	 public float getItemdesc() {
		 return itemdesc;
	 }
	 public void setItemdesc(float itemdesc) {
		 this.itemdesc = itemdesc;
	 }
	 public float getItemprice() {
		 return itemprice;
	 }
	 public void setItemprice(float itemprice) {
		 this.itemprice = itemprice;
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
	 @Override
	 public String toString() {
		return "ItemMaster [itemid=" + itemid + ", itemdesc=" + itemdesc + ", itemprice=" + itemprice + "]";
	 }
	 
}