package com.example.teams.datasources;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.teams.models.TeamsCollection;

@Component
public class RugbyApiClient {

  String API_KEY = System.getProperty("RUGBY_API_KEY");

  private static final String RUGBY_API_URL = "https://v1.rugby.api-sports.io";
  private final RestClient client = RestClient.builder()
      .defaultHeader("x-rapidapi-key", API_KEY)
      .baseUrl(RUGBY_API_URL).build();

  public TeamsCollection teamsRequest(String year, int leagueID) {
    return client
        .get()
        .uri(String.format("/teams?%s&%s", year,
            leagueID))
        .retrieve()
        .body(TeamsCollection.class);
  }
}