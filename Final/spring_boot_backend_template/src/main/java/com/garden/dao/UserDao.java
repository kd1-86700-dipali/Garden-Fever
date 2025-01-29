package com.garden.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

}
