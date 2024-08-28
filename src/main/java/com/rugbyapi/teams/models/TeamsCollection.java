package com.rugbyapi.teams.models;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rugbyapi.teams.generated.types.Team;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

public class TeamsCollection {
  List<Team> teams;

  public void setResponse(JsonNode teams) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    this.teams = mapper.readValue(teams.traverse(), new TypeReference<List<Team>>() {
    });
  }

  public List<Team> getTeams() {
    return this.teams;
  }
}