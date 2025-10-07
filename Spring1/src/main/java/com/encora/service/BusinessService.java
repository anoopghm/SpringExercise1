package com.encora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.encora.model.Account;
import com.encora.repository.AccountRepo;



@Service
public class BusinessService{
    
	 @Autowired
	 static
	 TransactionServiceImp1 ts=new TransactionServiceImp1();
	@Transactional(propagation = Propagation.REQUIRED)
	 public static void amountTransaction(int from, int to, float amount) throws Throwable {
		ts.credit(to, amount);
		ts.debit(from, amount);
	 }
}
