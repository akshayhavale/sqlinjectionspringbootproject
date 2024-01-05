package com.injenction.repository;

import java.util.List;

import com.injenction.entity.Users;

public interface CustomUsersRepository {

	public List<Users> searchUsersByUsername(String username);
}
