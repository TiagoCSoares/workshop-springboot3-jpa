package com.tiagocsoares.course.services;

import com.tiagocsoares.course.entities.Product;
import com.tiagocsoares.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }


    public Product findById(Long id) {
        // Verifica se o Optional contém um valor e retorna o objeto Product,
        // ou retorna null se o Optional estiver vazio.
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}


