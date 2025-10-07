package com.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("rsshop")
public class RamuShoeShop extends ShoeShop{
	public RamuShoeShop() {
		System.out.println("constructor called...");
	}
	
@PostConstruct
public void init() {
	System.out.println("after the constructor....");
}

@PreDestroy
public void destroy() {
	System.out.println("destroy method called...");
}
List<Customer>name = new ArrayList<>();
@Override
public Shoe sellShoe(Customer customer) throws MyCustomException{
	if(name.contains(customer)) {
		throw new MyCustomException();
	}else {
		name.add(customer);
	}
	return getFactory().makeShoe();
  }
}