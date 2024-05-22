package com.rugbyapi.teams.models;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rugbyapi.teams.generated.types.League;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

public class LeaguesCollection {
  List<League> leagues;

  public void setResponse(JsonNode leagues) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    this.leagues = mapper.readValue(leagues.traverse(), new TypeReference<List<League>>() {
    });
  }

  public List<League> getTeams() {
    return this.leagues;
  }
}