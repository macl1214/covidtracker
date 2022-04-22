package com.cubas.covidtracker.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cubas.covidtracker.model.CountryStat;
import com.cubas.covidtracker.service.CovidDataServiceImpl;

@Controller
public class CovidController {
	
	@Autowired
	CovidDataServiceImpl covidDataService;

	@GetMapping("/")
	public String getAllStats(Model model) throws URISyntaxException, IOException, InterruptedException {
		
//		covidDataService.getCovidData();
		
		List<CountryStat> countries = covidDataService.getAllStats();
		CountryStat worldStat = covidDataService.getGlobalStat();
		Date lastUpdatedDate = countries.get(0).getLastSavedDate();
		
//		System.out.println("First country: " + countries.get(0));
		
		System.out.println(lastUpdatedDate);
		
		model.addAttribute("countries", countries);
		model.addAttribute("worldStat", worldStat);
		model.addAttribute("lastUpdatedDate", lastUpdatedDate);
		
		return "covid/daily-cases";
	}
	
	@GetMapping("/country-details")
	public String getCountryStats(@RequestParam("isoCode") String isoCode,
								  Model model) {
		
		CountryStat country = covidDataService.getCountryStat(isoCode);
		
//		System.out.println("In getCountryStats! isoCode is " + isoCode);
//		System.out.println("Country is: " + country);
		
		if (country != null) {
		
			model.addAttribute("country", country);
			model.addAttribute("lastUpdatedDate", country.getLastSavedDate());
			return "covid/country-details";
		}
		
		return "covid/gathering-data";
	}

}
