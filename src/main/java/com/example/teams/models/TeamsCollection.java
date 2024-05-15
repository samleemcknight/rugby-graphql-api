package com.example.teams.models;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.io.IOException;

import com.example.teams.models.MappedTeam;

public class TeamsCollection {

  public void setTeams(JsonNode teams) throws IOException {
    JsonNode teamItems = teams.get("items");
    ObjectMapper mapper = new ObjectMapper();
    
    mapper.readValue(teamItems.traverse(), new TypeReference<List<MappedTeam>>(){});
  }
}