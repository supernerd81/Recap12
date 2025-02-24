package de.supernerd.recap12.controller;

import de.supernerd.recap12.records.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {

    @PostMapping("/todo")
    public void save(@RequestBody Todo todo) {

    }

    @DeleteMapping("/toto")
    public void delete(@RequestBody Todo todo) {

    }

    @GetMapping("/todo")
    public List<Todo> findAllTodos() {
        return null;
    }
}
