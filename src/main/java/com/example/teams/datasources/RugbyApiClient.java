package com.example.teams.datasources;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

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

  public TeamsCollection teamsRequest(String year, Integer leagueID) throws RestClientResponseException {
    try {
      var res = client
          .get()
          .uri(String.format("/teams?season=%s&league=%s", year,
              leagueID))
          .retrieve();
      System.out.println(res.body(String.class));
      return res.body(TeamsCollection.class);
    } catch (RestClientResponseException exc) {
      System.out
          .println(String.format("Error code %d : %s", exc.getStatusCode().value(),
              exc.getResponseBodyAsString()));
      throw new RestClientResponseException("", null, year, null, null, null);
    }
    // return client
    // .get()
    // .uri(String.format("/teams?season=%s&league=%s", year,
    // leagueID))
    // .retrieve().body(TeamsCollection.class);
  }
}