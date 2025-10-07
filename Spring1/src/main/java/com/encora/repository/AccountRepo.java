package com.encora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.Account;
import com.encora.model.Users;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>{
	 
}

