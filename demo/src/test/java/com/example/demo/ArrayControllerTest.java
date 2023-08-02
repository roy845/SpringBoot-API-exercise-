package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.ArrayInput;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ArrayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testArePermutations_whenPermutations() throws Exception {
        ArrayInput<Character> input = new ArrayInput<Character>(Arrays.asList('a', 'b', 'c'), Arrays.asList('b', 'c', 'a'));
        mockMvc.perform(post("/ispermuted")
                .with(httpBasic("user", "password")) 
                .content(asJsonString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testArePermutations_whenNotPermutations() throws Exception {
        ArrayInput<Character> input = new ArrayInput<Character>(Arrays.asList('a', 'b', 'c'), Arrays.asList('b', 'c', 'd'));
        mockMvc.perform(post("/ispermuted")
                .with(httpBasic("user", "password"))
                .content(asJsonString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void testArePermutations_whenNotPermutations1() throws Exception {
        ArrayInput<Character> input = new ArrayInput<Character>(Arrays.asList('a', 'b', 'c'), Arrays.asList('b', 'c', 'a', 'a'));
        mockMvc.perform(post("/ispermuted")
                .with(httpBasic("user", "password")) 
                .content(asJsonString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
    
    
    @Test
    public void testArePermutations_whenNotPermutations2() throws Exception {
        ArrayInput<Integer> input = new ArrayInput<Integer>(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3, 3));
        mockMvc.perform(post("/ispermuted")
                .with(httpBasic("user", "password")) 
                .content(asJsonString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
    
    
    @Test
    public void testArePermutations_whenPermutations2() throws Exception {
        ArrayInput<Integer> input = new ArrayInput<Integer>(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));
        mockMvc.perform(post("/ispermuted")
                .with(httpBasic("user", "password")) 
                .content(asJsonString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    //Converts a Java object into JSON representation
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
