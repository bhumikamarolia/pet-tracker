package com.example.pet_tracker;

import com.example.pet_tracker.controller.PetController;
import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

@WebMvcTest(PetController.class) // Loads only the PetController for testing
public class PetControllerTest {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    @MockBean
    private PetService petService; // Mocked service layer
    
    // Test if POST /pets/dog returns 200 OK when a valid Dog is submitted
    @Test
    public void testAddDogEndpointReturns200() throws Exception {
        Dog dog = new Dog("MEDIUM", 101, false);
        Mockito.when(petService.savePet(Mockito.any(Dog.class))).thenReturn(dog);

        mockMvc.perform(post("/pets/dog")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"trackerType\":\"MEDIUM\",\"ownerId\":101,\"inZone\":false}"))
            .andExpect(status().isOk());
    }
    
     // Test if POST /pets/cat returns 200 OK when a valid Cat (with lostTracker) is submitted
    @Test
    public void testAddCatEndpointReturns200() throws Exception {
        Cat cat = new Cat("SMALL", 2, false, true);
        Mockito.when(petService.savePet(Mockito.any(Cat.class))).thenReturn(cat);

        mockMvc.perform(post("/pets/cat")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"trackerType\":\"SMALL\", \"ownerId\":2, \"inZone\":false, \"lostTracker\":true}"))
            .andExpect(status().isOk());
    }
 
    // Test if GET /pets/out-of-zone returns 200 OK when service returns grouped counts
    @Test
    public void testOutOfZoneEndpointReturns200() throws Exception {
        Map<String, Long> response = new HashMap<>();
        response.put("Dog-MEDIUM", 1L);
        Mockito.when(petService.getOutOfZoneGroupedCounts()).thenReturn(response);

        mockMvc.perform(get("/pets/out-of-zone"))
            .andExpect(status().isOk());
    }



}
