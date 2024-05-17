package com.example.teams.datasources;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.teams.models.TeamsCollection;

import io.github.cdimascio.dotenv.Dotenv;

@Component
public class RugbyApiClient {
  private static final Dotenv dotenv = Dotenv.load();

  private String API_KEY = dotenv.get("RUGBY_API_KEY");

  private static final String RUGBY_API_URL = "https://v1.rugby.api-sports.io";
  private final RestClient client = RestClient.builder()
      .defaultHeader("x-rapidapi-key", API_KEY)
      .baseUrl(RUGBY_API_URL).build();

  public TeamsCollection teamsRequest(String year, Integer leagueID) {
    return client.get().uri(String.format("/teams?season=%s&league=%s", year,
        leagueID)).retrieve().body(TeamsCollection.class);
  }
}