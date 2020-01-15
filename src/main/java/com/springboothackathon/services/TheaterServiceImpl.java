package com.springboothackathon.services;

import com.springboothackathon.models.Theater;

import java.util.ArrayList;

public class TheaterServiceImpl implements TheaterService {
    public ArrayList<Theater> getAllTheaters() {
        Theater theater1 = new Theater();
        theater1.setId(23);
        theater1.setName("Joey Chestnut's theater. Hot dogs only");
        theater1.setLatitude(11L);
        theater1.setLatitude(19L);

        ArrayList<Theater> theaters = new ArrayList<Theater>();
        theaters.add(theater1);

        return theaters;
    }

    public Theater getTheaterById(int id) {
        return new Theater();
    }

    public void addTheater(Theater theater) {

    }

    public void updateTheater(Theater theater) {

    }

    @Override
    public void deleteTheater(Theater theater) {

    }
}
