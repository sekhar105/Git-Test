package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query(value = "select * from Product where count>0",nativeQuery = true)
	public Page<Product> getAllProductsPage(Pageable pageable);
}
