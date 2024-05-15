package com.example.teams.datasources;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.teams.models.TeamsCollection;

@Component
public class RugbyApiClient {

  private static final String RUGBY_API_URL = "https://v1.rugby.api-sports.io";  
  private final RestClient client = RestClient.builder().baseUrl(RUGBY_API_URL).build();

  public TeamsCollection teamsRequest() {
    return client
    .get()
    .uri("/teams?league=16&season=2023")
    .retrieve()
    .body(TeamsCollection.class);
  }
}