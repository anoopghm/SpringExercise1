package com.encora.model.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Students implements Serializable,Comparable<Students>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	private String sname;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
    @ManyToMany
	@JoinTable(
			name="student_courses",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns =@JoinColumn(name="course_id") 
			)
	private List<Course> courses=new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (sid != other.sid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}
	@Override
	public int compareTo(Students o) {
		return Integer.compare(this.sid, o.sid);
	}
}