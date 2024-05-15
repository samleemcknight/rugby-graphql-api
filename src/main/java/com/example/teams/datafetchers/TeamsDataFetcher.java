package com.example.teams.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.example.teams.datasources.RugbyApiClient;
import com.example.teams.models.MappedTeam;
import com.example.teams.models.TeamsCollection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class TeamsDataFetcher {

  private final RugbyApiClient apiClient;

  @Autowired
  public TeamsDataFetcher(RugbyApiClient rugbyApiClient) {
    this.apiClient = rugbyApiClient;
  }

  @DgsQuery
  public List<MappedTeam> getTeams(@InputArgument String year, @InputArgument Integer leagueID) {
    TeamsCollection response = apiClient.teamsRequest(year, leagueID);

    return response.getTeams();
  }
}