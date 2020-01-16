package springboothackathon.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import springboothackathon.models.Theater;
import springboothackathon.services.TheaterService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class TheaterControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Mock
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

        when(service.getAllTheaters()).thenReturn(theaters);

        mockMvc.perform(get("/theaters")).andDo(print());

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

        List<Theater> theaters = new ArrayList<Theater>();
        theaters.add(theater);

        when(service.getAllTheaters()).thenReturn(theaters);

        String result = mockMvc.perform(get("/theaters")).andReturn().getResponse().getContentAsString();

        assertThat(result.contains(theater.getName()));
    }
}
