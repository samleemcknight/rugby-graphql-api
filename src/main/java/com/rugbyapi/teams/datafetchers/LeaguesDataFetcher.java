package com.rugbyapi.teams.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.rugbyapi.teams.datasources.RugbyApiClient;

@DgsComponent
public class LeaguesDataFetcher extends DataFecherBase {
  public LeaguesDataFetcher(RugbyApiClient rugbyApiClient) {
    super(rugbyApiClient);
  }

  // @DgsData(parentType = "Team", field = "leagues")
  // public List<MappedTeam> leagues(DgsDataFetchingEnvironment dfe) {
  // MappedTeam team = dfe.getSource();

  // return apiClient.countriesRequest(team.getCountry)
  // }
}