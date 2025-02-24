package de.supernerd.recap12.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

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
}
