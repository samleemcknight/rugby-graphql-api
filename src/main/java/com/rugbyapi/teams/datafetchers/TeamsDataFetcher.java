package com.rugbyapi.teams.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.rugbyapi.teams.datasources.RugbyApiClient;
import com.rugbyapi.teams.models.MappedTeam;
import com.rugbyapi.teams.models.TeamsCollection;

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

  // @DgsData(parentType = "Team", field = "leagues")
  // public List<MappedTeam> leagues(DgsDataFetchingEnvironment dfe) {
  // MappedTeam team = dfe.getSource();

  // return apiClient.countriesRequest(team.getCountry)
  // }
}