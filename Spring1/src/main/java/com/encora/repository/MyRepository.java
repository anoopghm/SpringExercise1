package com.encora.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public class MyRepository {
    public MyRepository() {
		 System.out.println("Service cons called.....");
	}
}
