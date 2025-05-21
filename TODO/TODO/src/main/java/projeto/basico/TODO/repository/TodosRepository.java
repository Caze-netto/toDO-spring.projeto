package projeto.basico.TODO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.basico.TODO.entity.Todos;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    List<Todos> findByConcluido(boolean concluido);
}
