package de.supernerd.recap12.services;

import de.supernerd.recap12.enums.TodoStatus;
import de.supernerd.recap12.records.Todo;
import de.supernerd.recap12.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    TodoRepository todoRepository = mock(TodoRepository.class);
    TodoService todoService = new TodoService(todoRepository);

    @Test
    void findAllTodos() {
        //GIVEN
        Todo t1 = new Todo("1", "Desc1", TodoStatus.OPEN);
        Todo t2 = new Todo("2", "Desc2", TodoStatus.OPEN);
        Todo t3 = new Todo("3", "Desc3", TodoStatus.OPEN);
        List<Todo> todos = List.of(t1, t2, t3);
        when(todoRepository.findAll()).thenReturn(todos);

        //WHEN
        List<Todo> actual = todoService.findAllTodos();

        //THEN
        verify(todoRepository).findAll();
        assertEquals(todos, actual);
    }
}