package com.rugbyapi.teams.datafetchers;

import java.util.List;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.rugbyapi.teams.datasources.RugbyApiClient;
import com.rugbyapi.teams.models.LeaguesCollection;
import com.rugbyapi.teams.models.MappedLeague;

import graphql.com.google.common.base.Optional;

@DgsComponent
public class LeaguesDataFetcher extends DataFecherBase {
  public LeaguesDataFetcher(RugbyApiClient rugbyApiClient) {
    super(rugbyApiClient);
  }

  @DgsQuery
  public List<MappedLeague> getLeagues(@InputArgument Optional<Integer> countryID, @InputArgument Optional<String> year,
      @InputArgument Optional<Integer> leagueID) {
    // if (countryID != null) {
    // LeaguesCollection response =
    // this.apiClient.leaguesByCountryRequest(countryID);
    // return response.getLeagues();
    // }
    LeaguesCollection response = this.apiClient.leaguesRequest();
    return response.getLeagues();
  }

  // @DgsData(parentType = "Team", field = "leagues")
  // public List<MappedTeam> leagues(DgsDataFetchingEnvironment dfe) {
  // MappedTeam team = dfe.getSource();

  // return apiClient.countriesRequest(team.getCountry)
  // }
}