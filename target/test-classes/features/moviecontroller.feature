Feature: Testing the movie API

  Background:
    Given the server is running

    Scenario: Client requests list of all movies
      When client calls movie controller
      Then client receives a list of all movies