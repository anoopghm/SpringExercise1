package com.factory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("lsf")
@Primary
public class LakhaniShoeFactory extends ShoeFactory{
@Override
public Shoe makeShoe() {
	// TODO Auto-generated method stub
	return new SportsShoe();
}
}