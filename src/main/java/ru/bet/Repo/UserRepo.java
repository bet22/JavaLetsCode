package ru.bet.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bet.domen.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
