package com.rugbyapi.teams.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.rugbyapi.teams.datasources.RugbyApiClient;
import com.rugbyapi.teams.generated.types.Team;
import com.rugbyapi.teams.models.TeamsCollection;

import java.util.List;

@DgsComponent
public class TeamsDataFetcher extends DataFecherBase {

  public TeamsDataFetcher(RugbyApiClient rugbyApiClient) {
    super(rugbyApiClient);
  }

  @DgsQuery
  public List<Team> getTeams(@InputArgument String year, @InputArgument String leagueID) {
    TeamsCollection response = this.apiClient.teamsRequest(year, leagueID);

    return response.getTeams();
  }
}