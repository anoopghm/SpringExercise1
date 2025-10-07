package com.encora.model.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course implements Comparable<Course>,Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String cname;
	
	@ManyToMany(mappedBy="courses")
	private List<Students> students=new ArrayList();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
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
		Course other = (Course) obj;
		if (cid != other.cid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}
	
	@Override
	public int compareTo(Course o) {
		return Integer.compare(this.cid, o.cid);
	}
}