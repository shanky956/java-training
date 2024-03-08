package com.org.altech;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.altech.entity.User;
import com.org.altech.repository.UserRepository;


@SpringBootApplication
public class A3CustomersApiApplication {
	
	@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "Bob", "bob123", "bob@gmail.com"),
                new User(102, "John", "john123", "john@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(A3CustomersApiApplication.class, args);
	}

}
