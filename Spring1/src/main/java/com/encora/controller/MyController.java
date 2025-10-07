package com.encora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.encora.service.MyServiceImp1;

@Component
@Lazy
public class MyController {
  public MyController() {
	 System.out.println("Controller cons called ....");
  }
  
  @Autowired
  private MyServiceImp1 myservice;
}
