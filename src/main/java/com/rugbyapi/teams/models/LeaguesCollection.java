package com.rugbyapi.teams.models;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

public class LeaguesCollection {
  List<MappedLeague> leagues;

  public void setResponse(JsonNode leagues) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    this.leagues = mapper.readValue(leagues.traverse(), new TypeReference<List<MappedLeague>>() {
    });
  }

  public List<MappedLeague> getLeagues() {
    return this.leagues;
  }
}