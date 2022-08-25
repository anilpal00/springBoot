package com.hnt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // spring bean
public class UserController {//accept requests
	@Autowired//DI
	UserService userService; // dependency

	@GetMapping("/user")
	String getUser() {
		return "test";
	}

	@PostMapping("/user/age/{age}/height/{height}")  //base path
	void saveUser(@Valid @RequestBody User user, @PathVariable("age") int age, @PathVariable("height") float height) {
		userService.save(user);
		System.out.println(height);
		System.out.println(age);
		log.debug(user.getName());
	}
	@PostMapping("/user")
	void saveUser1(@RequestBody User user) {
		userService.save(user);
		log.debug(user.getName());
		System.out.println("second");
	}

}
