package de.supernerd.recap12.repository;

import de.supernerd.recap12.records.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
