package ru.bet.Repo;

import org.springframework.data.repository.CrudRepository;
import ru.bet.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
