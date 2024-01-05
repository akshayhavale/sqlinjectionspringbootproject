package com.injenction.service;

import java.util.List;

import com.injenction.entity.Users;

public interface UsersService {
	
	public List<Users> searchUsersByUsername(String username);

}
