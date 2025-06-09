package model.client;


public class CountryClient {

	private String countryCode;
	private String name;
	public CountryClient(String countryCode, String name) {
		super();
		this.countryCode = countryCode;
		this.name = name;
	}
	public CountryClient() {
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
		return "CountryClient [countryCode=" + countryCode + ", name=" + name + "]";
	}
	
}