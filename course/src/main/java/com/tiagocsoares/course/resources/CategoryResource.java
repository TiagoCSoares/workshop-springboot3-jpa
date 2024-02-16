package com.tiagocsoares.course.resources;

import com.tiagocsoares.course.entities.Category;
import com.tiagocsoares.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // uma classe que manipula solicitações HTTP e retorna respostas no formato de dados que não são vinculados a uma visualização específica, como JSON ou XML.
@RequestMapping(value= "/categories") // mapeia solicitações da web para classes de manipulador e métodos de manipulador específicos.
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping // Esta anotação indica que este método é mapeado para uma solicitação HTTP GET para a rota especificada.
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
