package by.tms.storage;

import by.tms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByFirstName(String string);
    boolean existsByUserName(String userName);
    void deleteByUserName(String login);
    boolean existsById(long id);
}
