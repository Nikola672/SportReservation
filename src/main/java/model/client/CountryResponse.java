package model.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import restClient.CountryClient;


@Path("/countries")
public class CountryResponse {

	@Inject
	@RestClient
	CountryClient countryClient;

	private String countryCode;
	private String name;

	public CountryResponse(String countryCode, String name) {
		super();
		this.countryCode = countryCode;
		this.name = name;
	}

	public CountryResponse() {
		super();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CountryResponse [countryCode=" + countryCode + ", name=" + name + "]";
	}

	@GET
	@Path("/getCountries")
	public String getCountries() {
		return countryClient.getCountries(countryCode, countryCode).toString();
	}

}