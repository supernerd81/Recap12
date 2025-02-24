package de.supernerd.recap12.dto;

import de.supernerd.recap12.enums.TodoStatus;

public record NewTodo(
        String description,
        TodoStatus status
) {
}
