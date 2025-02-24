package de.supernerd.recap12.controller;

import de.supernerd.recap12.dto.NewTodo;
import de.supernerd.recap12.dto.UpdateTodo;
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
    public Todo save(@RequestBody NewTodo newTodo) {
        return todoService.addTodo(newTodo);
    }

    @DeleteMapping("/todo")
    public void delete(@RequestBody Todo todo) {

    }

    @GetMapping("/todo")
    public List<Todo> findAllTodos() {

        return todoService.findAllTodos();
    }

    @PutMapping("/todo/{id}")
    public Todo putTodo(@RequestBody UpdateTodo todo, @PathVariable String id) {
        return todoService.updateTodo(todo, id);
    }

}
