package com.injenction.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.injenction.entity.Users;
import com.injenction.service.UsersService;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE, name = "GET ALL USERS")
	public List<Users> getUsersSearch(@PathVariable(value = "username") String username) {
		log.debug("Inside getUsersSearch for username : {}", username);
		return usersService.searchUsersByUsername(username);
	}

}
