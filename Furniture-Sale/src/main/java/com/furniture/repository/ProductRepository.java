package com.furniture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.furniture.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);
	
	boolean existsByName(String name);
	
	boolean existsByProductId(long id);

	@Modifying(clearAutomatically = true)
	@Query( value = "SELECT p FROM Product p WHERE p.category =:givenCategory")
	List<Product> findByCategory(@Param("givenCategory")String Category);
}
