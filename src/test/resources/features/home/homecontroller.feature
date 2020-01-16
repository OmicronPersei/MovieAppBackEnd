Feature: Testing the movie API
  User should be able to query for a movie.

  Background:
    //Given the server is running

    When the client performs a GET call on home controller

  Scenario: Get Call on Homepage
  client receives a correct response when they perform a get call on the Homepage.

    Then the client gets a success response

    Then the client receives the response string Greetings from Spring Boot!

    Then the client should be connected to the correct URL

    Then the client should be performing a GET call