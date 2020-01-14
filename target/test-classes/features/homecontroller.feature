Feature: Testing the movie API
  User should be able to query for a movie.

  Background:
    Given the server is running

  Scenario: Call Homepage
  client should see a success response when calling home controller

    When the client calls home controller
    Then the client gets a success response

    When the client calls home controller
    Then the client receives the response string Greetings from Spring Boot!