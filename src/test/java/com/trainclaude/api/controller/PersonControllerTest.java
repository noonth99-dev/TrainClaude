package com.trainclaude.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPersonReturnsNameAndId() throws Exception {
        mockMvc.perform(get("/api/person").param("name", "Alice").param("id", "42"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.id").value(42));
    }

    @Test
    void getPersonMissingParamsReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/person"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createPersonReturnsPostedBody() throws Exception {
        mockMvc.perform(post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":7,\"name\":\"Bob\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bob"))
                .andExpect(jsonPath("$.id").value(7));
    }
}
