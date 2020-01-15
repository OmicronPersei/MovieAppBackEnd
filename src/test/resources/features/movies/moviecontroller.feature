Feature: Testing the movie API

  //Background:
   //Given the server is running

    Scenario: Client requests list of all movies
      When the client calls movies controller
      Then the client receives a list of all movies