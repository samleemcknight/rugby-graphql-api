package com.rugbyapi.teams.datafetchers;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.util.Map;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.rugbyapi.teams.datasources.RugbyApiClient;
import com.rugbyapi.teams.generated.types.Team;
import com.rugbyapi.teams.models.LeaguesCollection;
import com.rugbyapi.teams.models.MappedLeague;

import graphql.execution.DataFetcherResult;

@DgsComponent
public class LeaguesDataFetcher extends DataFecherBase {
  public LeaguesDataFetcher(RugbyApiClient rugbyApiClient) {
    super(rugbyApiClient);
  }

  @DgsQuery
  public DataFetcherResult<List<MappedLeague>> getLeagues(@InputArgument String countryID, @InputArgument String year,
      @InputArgument Integer leagueID) {
    if (countryID != null && year != null) {
      LeaguesCollection response = this.apiClient.leaguesByCountryRequest(countryID);
      List<MappedLeague> leagues = response.getLeagues();
      return DataFetcherResult.<List<MappedLeague>>newResult()
          .data(leagues)
          .localContext(Map.of("year", year))
          .build();
    }
    LeaguesCollection response = this.apiClient.leaguesRequest();
    List<MappedLeague> leagues = response.getLeagues();
    return DataFetcherResult.<List<MappedLeague>>newResult()
        .data(leagues)
        .build();
  }

  @DgsData(parentType = "League")
  public List<Team> teams(DgsDataFetchingEnvironment dfe) throws IOException {
    MappedLeague league = dfe.getSource();
    String leagueId = league.getId();
    Map<String, String> localContext = dfe.getLocalContext();

    String year = localContext.get("year");
    if (localContext != null && year != null) {
      return apiClient.teamsRequest(year, leagueId).getTeams();
    }
    return apiClient.teamsRequest(Year.now().toString(), leagueId).getTeams();
  }
}