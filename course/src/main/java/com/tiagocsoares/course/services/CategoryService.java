package com.tiagocsoares.course.services;

import com.tiagocsoares.course.entities.Category;
import com.tiagocsoares.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }


    public Category findById(Long id) {
        // Verifica se o Optional contém um valor e retorna o objeto Category,
        // ou retorna null se o Optional estiver vazio.
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}


