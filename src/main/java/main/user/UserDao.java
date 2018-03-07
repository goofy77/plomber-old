package main.user;


import main.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, String> {

    boolean existsByEmail(String email);
    Optional<User> findUserByEmail(String email);
}
