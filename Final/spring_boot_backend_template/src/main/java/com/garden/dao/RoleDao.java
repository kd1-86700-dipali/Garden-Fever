package com.garden.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.entities.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
