package com.injenction.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.injenction.entity.Users;
import com.injenction.repository.UsersRepository;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> searchUsersByUsername(String username) {
		log.debug("Inside searchUsersByUsername for username : {} ", username);
		return usersRepository.searchUsersByUsername(username);
	}

}
