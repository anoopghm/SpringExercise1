package com.encora.service;

public interface TransactionService {
   public abstract void credit(int accountno,float amount) throws Throwable;
   public void debit(int accountno,float amount) throws Throwable;
}
 