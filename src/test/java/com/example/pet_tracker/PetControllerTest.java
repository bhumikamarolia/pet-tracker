package com.example.pet_tracker;

import com.example.pet_tracker.controller.PetController;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(PetController.class)
public class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @Test
    public void testAddDogEndpointReturns200() throws Exception {
        Dog dog = new Dog("MEDIUM", 101, false);
        Mockito.when(petService.savePet(Mockito.any(Dog.class))).thenReturn(dog);

        mockMvc.perform(post("/pets/dog")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"trackerType\":\"MEDIUM\",\"ownerId\":101,\"inZone\":false}"))
            .andExpect(status().isOk());
    }
}
