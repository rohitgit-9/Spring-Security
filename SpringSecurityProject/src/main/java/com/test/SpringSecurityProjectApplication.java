package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.entity.User;
import com.test.repo.UserRepo;

@SpringBootApplication
public class SpringSecurityProjectApplication  implements CommandLineRunner{
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		User user=new User();
//		user.setUsername("rohit");
//		user.setRole("ROLES_ADMIN");
//		user.setPassword(encoder.encode("1234"));
//		repo.save(user);
//		
//		
//		User user1=new User();
//		user1.setUsername("sandip");
//		user1.setRole("ROLES_ADMIN");
//		user1.setPassword(encoder.encode("1234"));
//		repo.save(user1);
	}

}
