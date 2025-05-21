package projeto.basico.TODO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.basico.TODO.entity.Todos;
import projeto.basico.TODO.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodosController {

    @Autowired
    public TodoService service;

    @PostMapping()
    public ResponseEntity<Todos> criarTodo(@RequestBody Todos todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarTodo(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaeTODO(@PathVariable long id){
        service.deletarTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAllTodos(){
        service.deletarAllTodo();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todos> listarTodo(@PathVariable long id){
        if(service.listarTodo(id) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodo(id));
    }

    @GetMapping
    public ResponseEntity<List<Todos>> listarAllTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAllTodo());
    }

    @GetMapping("/concluir/{id}")
    public ResponseEntity<Todos> concluirTodo(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.concluirTodo(id));
    }

    @GetMapping("/filtrarTodo/")
    public ResponseEntity<List<Todos>> filtrarTodo(@RequestParam boolean concluido){
        return ResponseEntity.status(HttpStatus.OK).body(service.filtrarTodo(concluido));
    }
}
