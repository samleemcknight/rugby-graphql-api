package com.example.teams.models;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

public class TeamsCollection {
  List<MappedTeam> teams;

  public void setResponse(JsonNode teams) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    this.teams = mapper.readValue(teams.traverse(), new TypeReference<List<MappedTeam>>() {
    });
  }

  public List<MappedTeam> getTeams() {
    return this.teams;
  }
}