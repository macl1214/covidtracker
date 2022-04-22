package com.cubas.covidtracker.service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.cubas.covidtracker.model.CountryStat;

@Service
public class CovidDataServiceImpl {

	@Value("${covid.cases.url}")
	private String url;
	
	@Value("${covid.cases.headers}")
	private List<String> headers;
	
	@Value("${covid.cases.code.world}")
	private String worldCode;
	
	@Value("${covid.cases.code.ignore}")
	private String ignoreCode;
	
	private Map<String, CountryStat> countries;
	
	@PostConstruct
	public void getCovidData() throws URISyntaxException, IOException, InterruptedException, ParseException {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
								.uri(new URI(url))
								.timeout(Duration.ofSeconds(10))
								.build();
		
		HttpResponse<String> response = client.send(request, 
												   HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(response.body());
		
		countries = new HashMap<>();
		Reader in = new StringReader(response.body());
		
		// Counters
		int i = 0;
		int numOfStrings = 3;
//		int numOfDoubles = 19; 
		
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			
			String isoCode = record.get(headers.get(0));
//		    System.out.print("isoCode = " + isoCode);
		    
		    String continent = record.get(headers.get(1));
//		    System.out.print("\ncontinent= " + continent);
		    
		    String location = record.get(headers.get(2));
//		    System.out.println("\nlocation= " + location);
		    
		    String lastUpdatedDateString = record.get(headers.get(3));
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date lastUpdatedDate = new Date(df.parse(lastUpdatedDateString).getTime());
		    
		    String totalCasesString = record.get(headers.get(4));
		    Double totalCases = parseDouble(totalCasesString);
//		    System.out.println("totalCases= " + totalCases);
		    
		    String newCasesString = record.get(headers.get(5));
		    Double newCases = parseDouble(newCasesString);
//		    System.out.println("totalCases= " + newCases);
		    
		    String totalDeathsString = record.get(headers.get(6));
		    Double totalDeaths = parseDouble(totalDeathsString);
//		    System.out.println("totalCases= " + totalDeaths);
		    
		    String newDeathsString = record.get(headers.get(7));
		    Double newDeaths = parseDouble(newDeathsString);
//		    System.out.println("newDeaths= " + newDeaths);
		    
		    String totalCasesPerMillionString = record.get(headers.get(8));
		    Double totalCasesPerMillion = parseDouble(totalCasesPerMillionString);
//		    System.out.println("totalCasesPerMillion= " + totalCasesPerMillion);
		    
		    String newCasesPerMillionString = record.get(headers.get(9));
		    Double newCasesPerMillion = parseDouble(newCasesPerMillionString);
//		    System.out.println("newCasesPerMillion= " + newCasesPerMillion);
		    
		    String totalDeathsPerMillionString = record.get(headers.get(10));
		    Double totalDeathsPerMillion = parseDouble(totalDeathsPerMillionString);
//		    System.out.println("totalDeathsPerMillion= " + totalDeathsPerMillion);
		    
		    String newDeathsPerMillionString = record.get(headers.get(11));
		    Double newDeathsPerMillion = parseDouble(newDeathsPerMillionString);
//		    System.out.println("newDeathsPerMillion= " + newDeathsPerMillion);
		    
		    String reproductionRateString = record.get(headers.get(12));
		    Double reproductionRate = parseDouble(reproductionRateString);
//		    System.out.println("reproductionRate= " + reproductionRate);
		    
		    String totalVaccinationsString = record.get(headers.get(13));
		    Double totalVaccinations = parseDouble(totalVaccinationsString);
//		    System.out.println("totalVaccinations= " + totalVaccinations);
		    
		    String peopleVaccinatedString = record.get(headers.get(14));
		    Double peopleVaccinated = parseDouble(peopleVaccinatedString);
//		    System.out.println("peopleVaccinated= " + peopleVaccinated);
		    
		    String peopleFullyVaccinatedString = record.get(headers.get(15));
		    Double peopleFullyVaccinated = parseDouble(peopleFullyVaccinatedString);
//		    System.out.println("peopleFullyVaccinated= " + peopleFullyVaccinated);
		    
		    String totalBoostersString = record.get(headers.get(16));
		    Double totalBoosters = parseDouble(totalBoostersString);
//		    System.out.println("totalBoosters= " + totalBoosters);
		    
		    String newVaccinationsString = record.get(headers.get(17));
		    Double newVaccinations = parseDouble(newVaccinationsString);
//		    System.out.println("newVaccinations= " + newVaccinations);
		    
		    String totalVaccinationsPerHundredString = record.get(headers.get(18));
		    Double totalVaccinationsPerHundred = parseDouble(totalVaccinationsPerHundredString);
//		    System.out.println("totalVaccinationsPerHundreds= " + totalVaccinationsPerHundred);
		    
		    String peopleVaccinatedPerHundredString = record.get(headers.get(19));
		    Double peopleVaccinatedPerHundred = parseDouble(peopleVaccinatedPerHundredString);
//		    System.out.println("peopleVaccinatedPerHundred= " + peopleVaccinatedPerHundred);
		    
		    String peopleFullyVaccinatedPerHundredString = record.get(headers.get(20));
		    Double peopleFullyVaccinatedPerHundred = parseDouble(peopleFullyVaccinatedPerHundredString);
//		    System.out.println("peopleFullyVaccinatedPerHundred= " + peopleFullyVaccinatedPerHundred);
		    
		    String totalBoostersPerHundredString = record.get(headers.get(21));
		    Double totalBoostersPerHundred = parseDouble(totalBoostersPerHundredString);
//		    System.out.println("totalBoostersPerHundred= " + totalBoostersPerHundred);
		    
		    String populationString = record.get(headers.get(22));
		    Double population = parseDouble(populationString);
//		    System.out.println("population= " + population);
		    
//		    System.out.println();
		    
//		    Country temp = new Country(isoCode, continent, location, totalCases);
		    CountryStat temp = new CountryStat(isoCode, continent, location, lastUpdatedDate, 
		    								   totalCases, newCases, totalDeaths,
				    						   newDeaths, totalCasesPerMillion, 
				    						   newCasesPerMillion, totalDeathsPerMillion,
				    						   newDeathsPerMillion, reproductionRate, 
				    						   totalVaccinations, peopleVaccinated,
				    						   peopleFullyVaccinated, totalBoosters,
				    						   newVaccinations, totalVaccinationsPerHundred,
				    						   peopleVaccinatedPerHundred, peopleFullyVaccinatedPerHundred,
				    						   totalBoostersPerHundred, population);
//		    System.out.println(temp);
		    
//		    System.out.println("isoCode = '" + isoCode + "'");
		    countries.put(isoCode.toLowerCase(), temp);
//		    break;
		}
		
	}
	
	public CountryStat getGlobalStat() {
		
		CountryStat worldStat = countries.get(worldCode);
		
		return worldStat;
	}
	
	public List<CountryStat> getAllStats() {
		
		Map<String, CountryStat> cMap = new HashMap<>(countries);
		Iterator<Entry<String, CountryStat>> mapIterator = cMap.entrySet().iterator();
		
//		System.out.println("Sucess in making a new Countries Map!");
		
		
		while (mapIterator.hasNext()) {
			
			Map.Entry<String, CountryStat> entry = 
							(Map.Entry<String, CountryStat>) mapIterator.next();
			
			CountryStat country = entry.getValue();
			String location = country.getLocation().toLowerCase();
//			System.out.println("location = " + location);
//			System.out.println("ignoreCode = " + ignoreCode);
			
			if (location.matches("(.*)" + ignoreCode + "(.*)")) {
//				System.out.println("location matches ignoreCode!");
				mapIterator.remove();
			}
		}
		
//		System.out.println("Looped over each key");
		
		List<CountryStat> countriesList = new ArrayList<CountryStat>(cMap.values());
		
		Collections.sort(countriesList);
		
		return countriesList;
	}
	
	public CountryStat getCountryStat(String isoCode) {
		
//		System.out.println(">>>>In getCountry()");
//		System.out.println(">>>>countries size = " + countries.size());
//		System.out.println(">>>>isoCode passed is " + isoCode);
		
		CountryStat country = countries.get(isoCode.toLowerCase());
		
		return country;
	}
	
	private Double parseDouble(String s) {
		
		return (s == null) || (s.isBlank()) ? null : NumberUtils.parseNumber(s, Double.class);
	}
}
