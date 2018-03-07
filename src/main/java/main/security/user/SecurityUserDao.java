package main.security.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecurityUserDao extends MongoRepository<SecurityUser, String> {
    SecurityUser findByUsername(String email);
}
