package main.upload;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileDao extends MongoRepository<DrawingFile, String> {
}
