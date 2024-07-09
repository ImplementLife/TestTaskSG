package sg.il.uaa.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.il.uaa.data.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
