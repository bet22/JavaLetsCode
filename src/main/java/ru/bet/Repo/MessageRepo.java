package ru.bet.Repo;

import org.springframework.data.repository.CrudRepository;
import ru.bet.Message;

public interface UserRepository extends CrudRepository<Message, Integer> {
}
