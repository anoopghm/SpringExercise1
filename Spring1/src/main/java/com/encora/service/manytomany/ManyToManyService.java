package com.encora.service.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.manytomany.Course;
import com.encora.model.manytomany.Students;
import com.encora.repository.manytomany.CourseRepo;
import com.encora.repository.manytomany.StudentsRepo;
import com.encora.repository.onetomany.EmployeeRepo;

@Service
public class ManyToManyService {

	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private StudentsRepo studentsRepo;
	
	public void insert() {
		Students s1=new Students();
		s1.setSname("ramu");		
		Students s2=new Students();
		s2.setSname("somu");
		
		Course java=new Course();
		java.setCname("Full stack java..");		
		Course dotNet=new Course();
		dotNet.setCname("Dot Net Full Stack");
		
		List<Course> courses=new ArrayList<>();
		courses.add(java);
		courses.add(dotNet);
		
		s1.setCourses(courses);
		
		courseRepo.save(java);
		courseRepo.save(dotNet);
		studentsRepo.save(s1);
		
	}
}