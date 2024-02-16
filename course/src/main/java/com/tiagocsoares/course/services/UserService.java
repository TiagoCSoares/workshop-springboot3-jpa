package com.tiagocsoares.course.services;

import com.tiagocsoares.course.entities.User;
import com.tiagocsoares.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }


    public User findById(Long id) {
        // Verifica se o Optional contém um valor e retorna o objeto User,
        // ou retorna null se o Optional estiver vazio.
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }


    public User insert(User obj) {
        return repository.save(obj);
    }
}


