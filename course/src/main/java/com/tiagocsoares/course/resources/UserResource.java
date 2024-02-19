package com.tiagocsoares.course.resources;

import com.tiagocsoares.course.entities.User;
import com.tiagocsoares.course.services.UserService;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // uma classe que manipula solicitações HTTP e retorna respostas no formato de dados que não são vinculados a uma visualização específica, como JSON ou XML.
@RequestMapping(value= "/users") // mapeia solicitações da web para classes de manipulador e métodos de manipulador específicos.
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping // Esta anotação indica que este método é mapeado para uma solicitação HTTP GET para a rota especificada.
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna uma resposta vazia erro 204
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }



}
