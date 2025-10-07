package com.factory;

import org.springframework.stereotype.Component;

@Component("bsf")
public class BataShoeFactory extends ShoeFactory{
@Override
public Shoe makeShoe() {
	// TODO Auto-generated method stub
	return new LeatherShoe();
}
}