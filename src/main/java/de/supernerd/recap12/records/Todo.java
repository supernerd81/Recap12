package de.supernerd.recap12.records;

import de.supernerd.recap12.enums.TodoStatus;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("todolist")
@With
public record Todo(
        String id,
        String description,
        TodoStatus status
) {
}
