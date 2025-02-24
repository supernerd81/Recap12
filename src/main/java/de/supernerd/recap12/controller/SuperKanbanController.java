package de.supernerd.recap12.controller;

import de.supernerd.recap12.records.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SuperKanbanController {

    public void save(@RequestBody Todo todo) {

    }
}
