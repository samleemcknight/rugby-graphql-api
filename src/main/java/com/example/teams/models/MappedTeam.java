package com.example.teams.models;

import com.example.teams.generated.types.Team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedTeam extends Team {
  // #TODO custom logic
}