package com.example.usersbooking;

import com.example.usersbooking.repository.IAuthRepository;
import com.example.usersbooking.repository.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class UsersBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersBookingApplication.class, args);
	}

}
