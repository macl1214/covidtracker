package com.cubas.covidtracker.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.cubas.covidtracker.model.CountryStat;

public interface CovidDataService {

	public void getCovidData();
	
	public List<CountryStat> formatCovidData();
}
