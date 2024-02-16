package com.tiagocsoares.course.repositories;

import com.tiagocsoares.course.entities.OrderItem;
import com.tiagocsoares.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}


