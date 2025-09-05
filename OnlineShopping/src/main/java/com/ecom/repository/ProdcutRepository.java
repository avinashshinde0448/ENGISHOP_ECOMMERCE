package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.beans.Product;

public interface ProdcutRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByIsActiveTrue();

}
