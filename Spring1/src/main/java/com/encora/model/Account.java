package com.encora.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int accountno;
     private float amount;
	 public int getAccountno() {
		 return accountno;
	 }
	 public void setAccountno(int accountno) {
		 this.accountno = accountno;
	 }
	 public float getAmount() {
		 return amount;
	 }
	 public void setAmount(float amount) {
		 this.amount = amount;
	 }
	 @Override
	 public int hashCode() {
		return Objects.hash(accountno);
	 }
	 @Override
	 public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountno == other.accountno;
	 }
	 @Override
	 public String toString() {
		return "Account [accountno=" + accountno + ", amount=" + amount + "]";
	 }
}
