package com.example.teams.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import com.example.teams.models.MappedTeam;
import java.util.List;

@DgsComponent
public class TeamDataFetcher {

  @DgsQuery
  public List<MappedTeam> getTeams() {
    // specific team related queries
  }
}