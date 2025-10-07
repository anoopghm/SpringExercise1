package com.encora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.encora.model.Account;
import com.encora.repository.AccountRepo;


@Service
@Transactional
public class TransactionServiceImp1 implements TransactionService{
	 @Autowired
	 private AccountRepo accrepo;
	 @Override 
	 @Transactional(propagation = Propagation.REQUIRED)
	 public void credit(int accNo, float amount)throws Throwable {
	  Account account = accrepo.findById(accNo)
	    .orElseThrow(() -> new InvalidUserException("Invalid Account No."));
	  float oldAmount = Optional.ofNullable(account).map(acc -> acc.getAmount())
	    .orElseThrow(() -> new InvalidUserException("Invalid Account No."));
	  account.setAmount(oldAmount + amount);
	  accrepo.save(account);
	 }
	 @Override
	 @Transactional(propagation = Propagation.REQUIRED, rollbackFor = InsufficientBalanceException.class)
	 public void debit(int accNo, float amount) throws Throwable {
	  Account account = accrepo.findById(accNo)
	    .orElseThrow(() -> new InvalidUserException("Invalid Account No."));
	  float oldAmount = Optional.ofNullable(account).map(acc -> acc.getAmount())
	    .orElseThrow(() -> new InvalidUserException("Invalid Account No."));
	  float newAmount = Optional.ofNullable(oldAmount).filter(o -> o - amount > 0)
	    .map(o -> o-amount)
	    .orElseThrow(() -> new InsufficientBalanceException("Insufficient Balance"));
	  account.setAmount(newAmount);
	  accrepo.save(account);
	 }
}


class InsufficientBalanceException extends Throwable{
	private String msg;
	public InsufficientBalanceException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg;
	}
}

class InvalidUserException extends Throwable{
	private String msg;
	public InvalidUserException(String msg) {
		 this.msg = msg;
	}
	public String toString() {
		return msg;
	}
}