package com.springboothackathon.controllers;

import com.springboothackathon.models.Theater;
import com.springboothackathon.services.TheaterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TheaterControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TheaterService service;

    @Test
    public void getTheatersHappyPath() throws Exception {
        Theater theater = new Theater();
        int id = 2;
        theater.setId(id);
        theater.setName("kevin");
        theater.setLatitude(22.3f);
        theater.setLongitude(22.3f);

        List<Theater> theaters = new ArrayList<Theater>();
        theaters.add(theater);

        mockMvc.perform(get("/theaters"));

        verify(service, times(1)).getAllTheaters();
    }

    @Test
    public void getTheatersCallsTheaterService() throws Exception {
        Theater theater = new Theater();
        int id = 2;
        theater.setId(id);
        theater.setName("kevin");
        theater.setLatitude(22.3f);
        theater.setLongitude(22.3f);

        ArrayList<Theater> theaters = new ArrayList<Theater>();
        theaters.add(theater);

        when(service.getAllTheaters()).thenReturn(theaters);

       mockMvc.perform(get("/theaters")).andExpect(status().isOk()).andReturn().getResponse();
    }

    @Test
    public void getTheaterByIdReturnsCorrectTheater() throws Exception {
        Theater theater = new Theater();
        int id = 4;
        theater.setId(id);
        theater.setLatitude(33L);
        theater.setName("bill");
        theater.setLongitude(11L);

        when(service.getTheaterById(id)).thenReturn(theater);

        mockMvc.perform(get("/theaters/id")
                .param("id", Integer.toString(id)))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("bill"))).andReturn().getResponse().getContentAsString();
    }

    @Test
    public void addCallsCorrectServiceMethod() throws Exception {
        Theater theater = new Theater();

        theater.setName("hahaha");
        theater.setLongitude(444444L);
        theater.setLatitude(123L);
        theater.setId(1234);

        mockMvc.perform(post("/theaters/add")).andDo(print()).andExpect(status().isOk());

        verify(service, times(1)).addTheater(theater);
    }
}
