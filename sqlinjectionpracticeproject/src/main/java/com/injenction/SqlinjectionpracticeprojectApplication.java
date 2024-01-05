package com.injenction;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.injenction.entity.Users;
import com.injenction.repository.UsersRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SqlinjectionpracticeprojectApplication {
	
	@Autowired
	private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(SqlinjectionpracticeprojectApplication.class, args);
	}
	
	@PostConstruct
	public void addUsersData() {
		List<Users> usersList = Arrays.asList(new Users("user1","12341"),
				new Users("user2","12342"),
				new Users("user3","12343"),
				new Users("user4","12344"),
				new Users("user5","12345"));
		usersRepository.saveAll(usersList);
	}

}
