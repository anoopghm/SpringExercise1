package com.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  private Long id;
  @Column(nullable = false)
  private String name;
  public User() {
	// TODO Auto-generated constructor stub
    }
  public User(Long id, String name) {
	  this.id = id;
	  this.name = name;
  }
  public Long getId() {
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  @Override
  public int hashCode() {
	return Objects.hash(id, name);
  }
  @Override
  public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }
}
