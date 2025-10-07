package com.encora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.encora.repository.MyRepository;

@Service
@Lazy
public class MyServiceImp1 implements MyService{
	@Autowired
	private MyRepository myrepo;
    public MyServiceImp1() {
		 System.out.println("MyService cons is called");
	}
}
