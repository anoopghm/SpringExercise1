package com.example.demo.mycontroller;

import jakarta.validation.constraints.Size;


//lifecycle spring
//jpa heibernate
//spring web : request mapping, controller,...
//post,get
//spring rest ; json request json response

public class User {
	@Size(min=5, max=10)
    private String uname;
    private String upass,phone,email;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String unpass) {
		this.upass = unpass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
