package com.injenction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.injenction.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>,CustomUsersRepository {

}
