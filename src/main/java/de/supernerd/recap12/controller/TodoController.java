package de.supernerd.recap12.controller;

import de.supernerd.recap12.records.Todo;
import de.supernerd.recap12.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo")
    public void save(@RequestBody Todo todo) {

    }

    @DeleteMapping("/toto")
    public void delete(@RequestBody Todo todo) {

    }

    @GetMapping("/todo")
    public List<Todo> findAllTodos() {

        return todoService.findAllTodos();
    }
}
