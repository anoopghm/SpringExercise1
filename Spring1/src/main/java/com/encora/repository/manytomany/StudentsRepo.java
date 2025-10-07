package com.encora.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.manytomany.Course;
import com.encora.model.manytomany.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer>{

}