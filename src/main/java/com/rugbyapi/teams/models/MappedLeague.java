package com.rugbyapi.teams.models;

import com.rugbyapi.teams.generated.types.League;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedLeague extends League {
  // #TODO custom logic
}