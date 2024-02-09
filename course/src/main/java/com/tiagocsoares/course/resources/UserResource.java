package com.tiagocsoares.course.resources;

import com.tiagocsoares.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // uma classe que manipula solicitações HTTP e retorna respostas no formato de dados que não são vinculados a uma visualização específica, como JSON ou XML.
@RequestMapping(value= "/users") // mapeia solicitações da web para classes de manipulador e métodos de manipulador específicos.
public class UserResource {

    @GetMapping // Esta anotação indica que este método é mapeado para uma solicitação HTTP GET para a rota especificada.
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
