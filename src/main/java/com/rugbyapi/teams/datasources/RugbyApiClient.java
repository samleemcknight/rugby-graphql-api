package com.rugbyapi.teams.datasources;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.rugbyapi.teams.models.LeaguesCollection;
import com.rugbyapi.teams.models.TeamsCollection;

import graphql.com.google.common.base.Optional;
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

  public LeaguesCollection leaguesByCountryRequest(Optional<Integer> countryId) {
    return client.get().uri(String.format("/leagues?country_id=%s", countryId)).retrieve()
        .body(LeaguesCollection.class);
  }

  public LeaguesCollection leaguesRequest() {
    return client.get().uri("/leagues").retrieve()
        .body(LeaguesCollection.class);
  }
}