Feature: Testing the movie API
  User should be able to query for a movie.

  Background:
    Given the server is running
    When the client performs a get call on home controller

  Scenario: Call Homepage
  client should see a success response when calling home controller

    Then the client gets a success response

    Then the client receives the response string Greetings from Spring Boot!
    
    Then the client should be connected to the correct URL