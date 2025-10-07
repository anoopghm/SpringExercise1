//package com.encora;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//import com.encora.controller.MyController;
//import com.encora.controller.UserController;
//import com.encora.service.MyServiceImp1;
//import com.encora.service.compkeyservice.CompKeyService;
//import com.encora.service.manytomany.ManyToManyService;
//import com.encora.service.onetomany.OneToManyService;
//import com.encora.service.onetoone.OneToOneService;
//import com.factory.Customer;
//import com.factory.Seller;
//import com.factory.Shoe;
//import com.factory.ShoeFactory;
//
//import jakarta.inject.Singleton;
//
//@SpringBootApplication
//@ComponentScan("com")
//public class EncoraApplication {
//
//    private final OneToOneService oneToOneService;
//
//    EncoraApplication(OneToOneService oneToOneService) {
//        this.oneToOneService = oneToOneService;
//    }
//	public static void main(String[] args){
////		try {
////	 ConfigurableApplicationContext ctx =	SpringApplication.run(EncoraApplication.class, args);
//////	  Seller seller = ctx.getBean("rsshop",Seller.class);
//////	  Customer c = new Customer("ramesh");
//////	  Shoe shoe = seller.sellShoe(c);
//////	  System.out.println(c);
////	  UserController uc=ctx.getBean(UserController.class);
////	  System.out.println(uc.login("ramu", "secret"));
////		}catch(Exception e) {
////		}
//		
//		try {
//			ConfigurableApplicationContext ctx= 
//					SpringApplication.run(EncoraApplication.class, args);			
//			
////			OneToOneService onetoone=ctx.getBean(OneToOneService.class);
////			onetoone.insert();
////			
////			OneToManyService onetomany=ctx.getBean(OneToManyService.class);
////			onetomany.create();
////			
////			ManyToManyService manytomany=ctx.getBean(ManyToManyService.class);
////			manytomany.insert();
//			
//			CompKeyService service=ctx.getBean(CompKeyService.class);
//			service.insert();
//
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		
//	}
//}


package com.encora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.encora.service.compkeyservice.CompKeyService;


@SpringBootApplication
@ComponentScan("com")
public class EncoraApplication {
	public static void main(String[] args) {
		try {
		ConfigurableApplicationContext ctx= 
				SpringApplication.run(EncoraApplication.class, args);			
		
//		OneToOneService onetoone=ctx.getBean(OneToOneService.class);
//		onetoone.insert();
//		
//		OneToManyService onetomany=ctx.getBean(OneToManyService.class);
//		onetomany.create();
		
//		ManyToManyService manytomany=ctx.getBean(ManyToManyService.class);
//		manytomany.insert();
		
		CompKeyService service=ctx.getBean(CompKeyService.class);
		service.insert();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}