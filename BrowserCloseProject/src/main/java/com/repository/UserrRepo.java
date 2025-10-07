package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserrRepo extends JpaRepository<User,Integer>{
    public User findByUsername(String uname);
    public User findByUsernameAndUserpass(String uname,String upass);
}