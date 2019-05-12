package todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todoList.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

}
