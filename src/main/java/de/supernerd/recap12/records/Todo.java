package de.supernerd.recap12.records;

import de.supernerd.recap12.enums.TodoStatus;

public record Todo(
        String description,
        TodoStatus status
) {
}
