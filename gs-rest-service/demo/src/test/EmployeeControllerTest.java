package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees/"))
               .andExpect(status().isOk());
    }

    @Test
    public void testAddEmployee() throws Exception {
        
        String json = "{"
                + "\"employee_id\": \"99\","
                + "\"first_name\": \"Unit\","
                + "\"last_name\": \"Test\","
                + "\"email\": \"unit@test.com\","
                + "\"title\": \"Engineer\""
                + "}";

        mockMvc.perform(post("/employees/")
               .contentType(MediaType.APPLICATION_JSON)
               .content(json))
               .andExpect(status().isCreated()) 
               .andExpect(header().exists("Location")); 
    }
}