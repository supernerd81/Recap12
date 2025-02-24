package de.supernerd.recap12.services;

import de.supernerd.recap12.dto.NewTodo;
import de.supernerd.recap12.dto.UpdateTodo;
import de.supernerd.recap12.enums.TodoStatus;
import de.supernerd.recap12.records.Todo;
import de.supernerd.recap12.repository.TodoRepository;
import de.supernerd.recap12.tools.IdService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    TodoRepository todoRepository = mock(TodoRepository.class);
    IdService idService = mock(IdService.class);
    TodoService todoService = new TodoService(todoRepository, idService);

    @Test
    void findAllTodos() {
        //GIVEN
        Todo t1 = new Todo("1", "Desc1", TodoStatus.OPEN.toString());
        Todo t2 = new Todo("2", "Desc2", TodoStatus.OPEN.toString());
        Todo t3 = new Todo("3", "Desc3", TodoStatus.OPEN.toString());
        List<Todo> todos = List.of(t1, t2, t3);
        when(todoRepository.findAll()).thenReturn(todos);

        //WHEN
        List<Todo> actual = todoService.findAllTodos();

        //THEN
        verify(todoRepository).findAll();
        assertEquals(todos, actual);
    }

    @Test
    void addTodo() {
        //GIVEN
        NewTodo newTodo = new NewTodo("Test-description", "OPEN");
        Todo todoToSave = new Todo("17", "Test-description", "OPEN");

        when(idService.randomId()).thenReturn("17");
        when(todoRepository.save(todoToSave)).thenReturn(todoToSave);

        //WHEN
        Todo actual = todoService.addTodo(newTodo);

        //THEN
        verify(idService).randomId();
        verify(todoRepository).save(todoToSave);
        assertEquals(todoToSave, actual);
    }

    @Test
    void updateTodo() {
        //GIVEN
        String id = "123";
        UpdateTodo todoToUpdate = new UpdateTodo("test-description", "IN_PROGRESS");
        Todo updatedToDo = new Todo("123", "test-description", "IN_PROGRESS");

        //WHEN
        when(todoRepository.save(updatedToDo)).thenReturn(updatedToDo);

        Todo actual = todoService.updateTodo(todoToUpdate, id);

        //THEN
        verify(todoRepository).save(updatedToDo);

        assertEquals(updatedToDo, actual);
    }
}