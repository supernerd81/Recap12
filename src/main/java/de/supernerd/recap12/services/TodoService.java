package de.supernerd.recap12.services;

import de.supernerd.recap12.dto.NewTodo;
import de.supernerd.recap12.records.Todo;
import de.supernerd.recap12.repository.TodoRepository;
import de.supernerd.recap12.tools.IdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final IdService idService;

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(NewTodo newTodo) {
        String id = idService.randomId();
        Todo todoToSave = new Todo(id, newTodo.description(), newTodo.status());

        return todoRepository.save(todoToSave);
    }
}
