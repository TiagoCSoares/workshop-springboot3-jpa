package com.tiagocsoares.course.services;

import com.tiagocsoares.course.entities.Order;
import com.tiagocsoares.course.repositories.OrderRepository;
import com.tiagocsoares.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }


    public Order findById(Long id) {
        // Verifica se o Optional contém um valor e retorna o objeto Order,
        // ou retorna null se o Optional estiver vazio.
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}


