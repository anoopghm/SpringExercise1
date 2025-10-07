package com.example.demo.mycontroller;

//x`import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyRestController {
	//http://localhost:8080/hello
	@GetMapping
	//@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("welcome to spring MVC.....");
	}
	
	//http://localhost:8080/hello/hello2
	//@RequestMapping(value="hello2", method = RequestMethod.GET)
	@GetMapping("/hello2")
	public String sayHello2() {
		System.out.println("sayhello2 method is called.............");
		return "wel";
	}
	//http://localhost:8080/hello/hello3
	//@RequestMapping(method = RequestMethod.GET, value="hello3")
	@GetMapping("/hello3")
	public ResponseEntity<String> sayHello3() {
      return ResponseEntity.ok("hai and welcome to spring mvc");
  }
	
	//@RequestMapping(method = RequestMethod.GET, value="hello4")
	@GetMapping("/hello4")
	public ResponseEntity<Users> sayHello10() {
		Users user=new Users();
		user.setUid(100);
		user.setUname("ramu");
      return ResponseEntity.ok(user);
  }
	//@RequestMapping(method = RequestMethod.POST, value="hello5")
	@PostMapping("/hello5")
	public ResponseEntity<Users> sayHello11(@RequestBody Users user) {
		//User user=new User();
		user.setUid(100+user.getUid());
		user.setUname("ramu"+user.getUname());
      return ResponseEntity.ok(user);
  }
	
	//@RequestMapping(method = RequestMethod.POST, value="hello12")
	@PostMapping("/hello6")
	public Users sayHello10(@RequestBody Users user) {
		//User user=new User();
		user.setUid(199900);
		user.setUname("dfjdsa;jfdskjfads;lkj");
      return user;
  }
//	@GetMapping("/set/{name}")
//  public String setSession(@PathVariable String name, HttpSession session) {
//      session.setAttribute("username", name);
//      return "Session value set for username: " + name;
//  }
//  @GetMapping("/get")
//  public String getSession(HttpSession session) {
//      String name=(String)session.getAttribute("username");
//      return "Session value got for username: " + name;
//  }
  
  @GetMapping("/getmyuser")
  public Users getUser() {
  	Users user=new Users();
  	user.setUid(100);
  	user.setUname("ramu");
  	return user;
  }
	
}

class Users{
	private int uid;
	private String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
