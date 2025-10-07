package com.encora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
	public Users findByUsername(String username);
	public Users findByUsernameAndUserpass(String username, String password);
	public Optional findById(int id);
}

