package projeto.basico.TODO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.basico.TODO.entity.Todos;
import projeto.basico.TODO.repository.TodosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodosRepository repository;

    public TodoService(TodosRepository repository){
        this.repository = repository;
    }

    public Todos criarTodo(Todos todo){
        repository.save(todo);
        return todo;
    }

    public void deletarTodo(long id){
        repository.deleteById(id);
    }

    public void deletarAllTodo(){
        repository.deleteAll();
    }

    public Todos listarTodo(long id){
        return repository.findById(id).orElse(null);
    }

    public List<Todos> listarAllTodo(){
        return repository.findAll();
    }

    public Todos concluirTodo(long id){
        Todos todo = listarTodo(id);
        todo.setConcluido(true);
        return repository.save(todo);
    }

    public List<Todos> filtrarTodo(boolean concluido){return repository.findByConcluido(concluido);
    }

}
