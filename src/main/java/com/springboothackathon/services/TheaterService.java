package com.springboothackathon.services;

import com.springboothackathon.models.Theater;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface TheaterService {
    ArrayList<Theater> getAllTheaters();

    Theater getTheaterById(int id);
}
