package com.cubas.covidtracker.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CountryStat implements Comparable<CountryStat> {

	private String isoCode;
	private String continent;
	private String location;
	
	private Date lastUpdatedDate;

	private Double totalCases;
	private Double newCases;
	
	private Double totalDeaths;
	private Double newDeaths;
	
	private Double totalCasesPerMillion;
	private Double newCasesPerMillion;
	
	private Double totalDeathsPerMillion;
	private Double newDeathsPerMillion;
	
	private Double reproductionRate;
	
	private Double totalVaccinations;
	private Double peopleVaccinated;
	private Double peopleFullyVaccinated;
	
	private Double totalBoosters;
	private Double newVaccinations;
	
	private Double totalVaccinationsPerHundred;
	private Double peopleVaccinatedPerHundred;
	private Double peopleFullyVaccinatedPerHundred;

	private Double totalBoostersPerHundred;
	
	private Double population;

	public CountryStat(String isoCode, String continent, String location, Double totalCases) {
		this.isoCode = isoCode;
		this.continent = continent;
		this.location = location;
		this.totalCases = totalCases;
	}

	public CountryStat(String isoCode, String continent, String location, Double totalCases, Double newCases,
			Double totalDeaths, Double newDeaths) {
		this.isoCode = isoCode;
		this.continent = continent;
		this.location = location;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
	}

	public CountryStat(String isoCode, String continent, String location, Date lastUpdatedDate, 
					   Double totalCases, Double newCases, Double totalDeaths, 
					   Double newDeaths, Double totalCasesPerMillion, 
					   Double newCasesPerMillion, Double totalDeathsPerMillion, 
					   Double newDeathsPerMillion, Double reproductionRate, 
					   Double totalVaccinations, Double peopleVaccinated, 
					   Double peopleFullyVaccinated, Double totalBoosters, 
					   Double newVaccinations, Double totalVaccinationsPerHundred, 
					   Double peopleVaccinatedPerHundred, Double peopleFullyVaccinatedPerHundred, 
					   Double totalBoostersPerHundred, Double population) {
		
		this.isoCode = isoCode;
		this.continent = continent;
		this.location = location;
		this.lastUpdatedDate = lastUpdatedDate;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
		this.totalCasesPerMillion = totalCasesPerMillion;
		this.newCasesPerMillion = newCasesPerMillion;
		this.totalDeathsPerMillion = totalDeathsPerMillion;
		this.newDeathsPerMillion = newDeathsPerMillion;
		this.reproductionRate = reproductionRate;
		this.totalVaccinations = totalVaccinations;
		this.peopleVaccinated = peopleVaccinated;
		this.peopleFullyVaccinated = peopleFullyVaccinated;
		this.totalBoosters = totalBoosters;
		this.newVaccinations = newVaccinations;
		this.totalVaccinationsPerHundred = totalVaccinationsPerHundred;
		this.peopleVaccinatedPerHundred = peopleVaccinatedPerHundred;
		this.peopleFullyVaccinatedPerHundred = peopleFullyVaccinatedPerHundred;
		this.totalBoostersPerHundred = totalBoostersPerHundred;
		this.population = population;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getLastSavedDate() {
		return lastUpdatedDate;
	}

	public void setLastSavedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Double getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Double totalCases) {
		this.totalCases = totalCases;
	}

	public Double getNewCases() {
		return newCases;
	}

	public void setNewCases(Double newCases) {
		this.newCases = newCases;
	}

	public Double getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Double totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Double getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Double newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Double getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}

	public void setTotalCasesPerMillion(Double totalCasesPerMillion) {
		this.totalCasesPerMillion = totalCasesPerMillion;
	}

	public Double getNewCasesPerMillion() {
		return newCasesPerMillion;
	}

	public void setNewCasesPerMillion(Double newCasesPerMillion) {
		this.newCasesPerMillion = newCasesPerMillion;
	}

	public Double getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}

	public void setTotalDeathsPerMillion(Double totalDeathsPerMillion) {
		this.totalDeathsPerMillion = totalDeathsPerMillion;
	}

	public Double getNewDeathsPerMillion() {
		return newDeathsPerMillion;
	}

	public void setNewDeathsPerMillion(Double newDeathsPerMillion) {
		this.newDeathsPerMillion = newDeathsPerMillion;
	}

	public Double getReproductionRate() {
		return reproductionRate;
	}

	public void setReproductionRate(Double reproductionRate) {
		this.reproductionRate = reproductionRate;
	}

	public Double getTotalVaccinations() {
		return totalVaccinations;
	}

	public void setTotalVaccinations(Double totalVaccinations) {
		this.totalVaccinations = totalVaccinations;
	}

	public Double getPeopleVaccinated() {
		return peopleVaccinated;
	}

	public void setPeopleVaccinated(Double peopleVaccinated) {
		this.peopleVaccinated = peopleVaccinated;
	}

	public Double getPeopleFullyVaccinated() {
		return peopleFullyVaccinated;
	}

	public void setPeopleFullyVaccinated(Double peopleFullyVaccinated) {
		this.peopleFullyVaccinated = peopleFullyVaccinated;
	}

	public Double getTotalBoosters() {
		return totalBoosters;
	}

	public void setTotalBoosters(Double totalBoosters) {
		this.totalBoosters = totalBoosters;
	}

	public Double getNewVaccinations() {
		return newVaccinations;
	}

	public void setNewVaccinations(Double newVaccinations) {
		this.newVaccinations = newVaccinations;
	}

	public Double getTotalVaccinationsPerHundred() {
		return totalVaccinationsPerHundred;
	}

	public void setTotalVaccinationsPerHundred(Double totalVaccinationsPerHundred) {
		this.totalVaccinationsPerHundred = totalVaccinationsPerHundred;
	}

	public Double getPeopleVaccinatedPerHundred() {
		return peopleVaccinatedPerHundred;
	}

	public void setPeopleVaccinatedPerHundred(Double peopleVaccinatedPerHundred) {
		this.peopleVaccinatedPerHundred = peopleVaccinatedPerHundred;
	}

	public Double getPeopleFullyVaccinatedPerHundred() {
		return peopleFullyVaccinatedPerHundred;
	}

	public void setPeopleFullyVaccinatedPerHundred(Double peopleFullyVaccinatedPerHundred) {
		this.peopleFullyVaccinatedPerHundred = peopleFullyVaccinatedPerHundred;
	}

	public Double getTotalBoostersPerHundred() {
		return totalBoostersPerHundred;
	}

	public void setTotalBoostersPerHundred(Double totalBoostersPerHundred) {
		this.totalBoostersPerHundred = totalBoostersPerHundred;
	}

	public Double getPopulation() {
		return population;
	}

	public void setPopulation(Double population) {
		this.population = population;
	}

	@Override
	public String toString() {

//		return "Country [isoCode=" + isoCode + ", continent=" + continent
//			 + ", location=" + location + ", totalCases=" + totalCases 
//			 + ", newCases=" + newCases + ", totalDeaths=" + totalDeaths 
//			 + ", newDeaths=" + newDeaths + "]";
		
		return "Country [isoCode=" + isoCode + ", continent=" + continent + ", location=" + location + ", totalCases="
				+ totalCases + ", newCases=" + newCases + ", totalDeaths=" + totalDeaths + ", newDeaths=" + newDeaths
				+ ", totalCasesPerMillion=" + totalCasesPerMillion + ", newCasesPerMillion=" + newCasesPerMillion
				+ ", totalDeathsPerMillion=" + totalDeathsPerMillion + ", newDeathsPerMillion=" + newDeathsPerMillion
				+ ", reproductionRate=" + reproductionRate + ", totalVaccinations=" + totalVaccinations
				+ ", peopleVaccinated=" + peopleVaccinated + ", peopleFullyVaccinated=" + peopleFullyVaccinated
				+ ", totalBoosters=" + totalBoosters + ", newVaccinations=" + newVaccinations
				+ ", totalVaccinationsPerHundred=" + totalVaccinationsPerHundred + ", peopleVaccinatedPerHundred="
				+ peopleVaccinatedPerHundred + ", peopleFullyVaccinatedPerHundred=" + peopleFullyVaccinatedPerHundred
				+ ", totalBoostersPerHundred=" + totalBoostersPerHundred + ", population=" + population + "]";
	}

//	For Comparable interface
	@Override
	public int compareTo(CountryStat other) {
	
		return this.location.compareTo(other.location);
	}

//	For HashMap usage
	@Override
	public int hashCode() {
//		return (isoCode.toString() + continent.toString() + location.toString() + totalCases.toString()
//			 + newCases.toString() + totalDeaths.toString() + newDeaths.toString()).hashCode();
		
		return (isoCode.toString() + continent.toString() + location.toString() + totalCases.toString()
		+ newCases.toString() + totalDeaths.toString() + newDeaths.toString() + totalCasesPerMillion.toString() 
		+ newCasesPerMillion.toString() + totalDeathsPerMillion.toString() + newDeathsPerMillion.toString() 
		+ reproductionRate.toString() + totalVaccinations.toString() + peopleVaccinated.toString() 
		+ peopleFullyVaccinated.toString() + totalBoosters.toString() + newVaccinations.toString() 
		+ totalVaccinationsPerHundred.toString() + peopleVaccinatedPerHundred.toString() 
		+ peopleFullyVaccinatedPerHundred.toString() + totalBoostersPerHundred.toString() 
		+ population.toString()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
	        return true;
		}
		
	    if (!(obj instanceof CountryStat)) {
	        return false;
	    }
	    
	    CountryStat other = (CountryStat) obj;
	    
	    boolean equivalentCountries = (this.isoCode == null && other.isoCode == null)
	      || (this.isoCode != null && this.isoCode.equals(other.isoCode));
	    
	    return equivalentCountries;
	}
	
}
