package com.rugbyapi.teams.datafetchers;

import org.springframework.beans.factory.annotation.Autowired;

import com.rugbyapi.teams.datasources.RugbyApiClient;

public class DataFecherBase {
  protected RugbyApiClient apiClient;

  @Autowired
  public DataFecherBase(RugbyApiClient rugbyApiClient) {
    this.apiClient = rugbyApiClient;
  }
}