package com.tiagocsoares.course.repositories;

import com.tiagocsoares.course.entities.Category;
import com.tiagocsoares.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}


