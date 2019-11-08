package respositories;

import models.Todo;
import models.User;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Long> {
}
