package ru.bet.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bet.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
