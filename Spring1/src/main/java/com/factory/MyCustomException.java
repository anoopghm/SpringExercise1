package com.factory;

public class MyCustomException extends Exception{
    public MyCustomException() {
		System.out.println("Customer Already exist");
	}
}
