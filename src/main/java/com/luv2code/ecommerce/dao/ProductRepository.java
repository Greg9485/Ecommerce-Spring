package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    //Below query runs a sql command = 'select * from product where name like concat('%', name, '%')
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
