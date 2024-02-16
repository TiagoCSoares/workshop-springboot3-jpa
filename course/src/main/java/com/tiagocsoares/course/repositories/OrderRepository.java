package com.tiagocsoares.course.repositories;

import com.tiagocsoares.course.entities.Order;
import com.tiagocsoares.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}


