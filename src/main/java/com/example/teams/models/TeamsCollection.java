package com.example.teams.models;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

public class TeamsCollection {
  List<MappedTeams> teams;

  public void setTeams(JsonNode teams) throws IOException {
    JsonNode teamItems = teams.get("response");
    ObjectMapper mapper = new ObjectMapper();

    this.teams = mapper.readValue(teamItems.traverse(), new TypeReference<List<MappedTeams>>() {
    });
  }

  public List<MappedTeams> getTeams() {
    return this.teams;
  }
}