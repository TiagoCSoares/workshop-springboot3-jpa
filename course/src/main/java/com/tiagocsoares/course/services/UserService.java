package com.tiagocsoares.course.services;

import com.tiagocsoares.course.entities.User;
import com.tiagocsoares.course.repositories.UserRepository;
import com.tiagocsoares.course.services.exceptions.DataBaseException;
import com.tiagocsoares.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));    // Retorna o objeto User ou lança uma exceção
        // Tenta o método .get(), se não conseguir, lança a exceção, no caso a exceção personalizada ResourceNotFoundException
    }


    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete (Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) { // O obj User contém os dados do novo Usuário
        User entity = repository.getOne(id);   // Prepara o objeto e depois efetua a operação no banco de dados
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }


}




