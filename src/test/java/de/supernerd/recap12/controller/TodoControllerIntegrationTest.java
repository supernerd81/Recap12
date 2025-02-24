package de.supernerd.recap12.controller;

import de.supernerd.recap12.enums.TodoStatus;
import de.supernerd.recap12.records.Todo;
import de.supernerd.recap12.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepository todoRepository;

    @Test
    @DirtiesContext
    void getAllTodos() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                      []
                  """));

    }

    @Test
    @DirtiesContext
    void saveTodo() throws Exception {
        //GIVEN


        //WHEN
        mockMvc.perform(post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "description": "test-description",
                          "status": "OPEN"
                        }
                  """))
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            {
                              "description": "test-description",
                              "status": "OPEN"
                            }
                      """))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    @DirtiesContext
    void putTodo() throws Exception {
        //GIVEN
        Todo existingTodo = new Todo("1", "test-description", TodoStatus.OPEN);
        todoRepository.save(existingTodo);

        //THEN
        mockMvc.perform(put("/api/todo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                  {
                      "description": "test-description-2",
                      "status": "IN_PROGRESS"
                  }
                  """)
        )
                .andExpect(status().isOk())
                .andExpect(content().json("""
                      {
                          "id": "1",
                          "description": "test-description-2",
                          "status": "IN_PROGRESS"
                      }
                  """));

        //WHEN

    }

    @Test
    @DirtiesContext
    void getById() throws Exception {
        //GIVEN
        Todo existingTodo = new Todo("1", "test-description", TodoStatus.OPEN);
        todoRepository.save(existingTodo);

        //WHEN
        mockMvc.perform(get("/api/todo/1"))

        //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                          {
                              "id": "1",
                              "description": "test-description",
                              "status": "OPEN"
                          }
                      """));
    }

    @Test
    @DirtiesContext
    void getByIdTest_whenInvalidId_thenStatus404() throws Exception {
        //GIVEN
        //WHEN
        mockMvc.perform(get("/api/todo/1"))

        //THEN
                .andExpect(status().isNotFound());
    }

    @Test
    @DirtiesContext
    void deleteTodoById() throws Exception {
        //GIVEN
        Todo existingTodo = new Todo("1", "test-description", TodoStatus.OPEN);
        todoRepository.save(existingTodo);

        //WHEN
        mockMvc.perform(delete("/api/todo/1"))

        //THEN
                .andExpect(status().isOk());
    }

}
