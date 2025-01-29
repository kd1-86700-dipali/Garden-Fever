package com.garden.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
