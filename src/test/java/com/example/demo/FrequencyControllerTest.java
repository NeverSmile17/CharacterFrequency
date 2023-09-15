package com.example.demo;

import com.example.demo.controller.FrequencyController;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FrequencyControllerTest {

    private final static FrequencyController CONTROLLER = new FrequencyController();
    private final static MockMvc MOCK_MVC = MockMvcBuilders.standaloneSetup(CONTROLLER).build();

    @Test
    public void testCalculateFrequencyWithEmptyString() throws Exception {
        String input = "";
        MOCK_MVC.perform(MockMvcRequestBuilders.post("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCalculateFrequencyWithOneCharacter() throws Exception {
        String input = "a";
        MOCK_MVC.perform(MockMvcRequestBuilders.post("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].symbol").value("a"))
                .andExpect(jsonPath("$[0].count").value(1));
    }

    @Test
    public void testCalculateFrequencyWithDifferentCase() throws Exception {
        String input = "aAaA";
        MOCK_MVC.perform(MockMvcRequestBuilders.post("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].symbol").value("A"))
                .andExpect(jsonPath("$[0].count").value(2))
                .andExpect(jsonPath("$[1].symbol").value("a"))
                .andExpect(jsonPath("$[1].count").value(2));
    }
}