package restClient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import model.client.CountryResponse;

@Path("/v3")
@RegisterRestClient(configKey = "country-api")
public interface CountryClient {
	@Path("/availableCountries")
	@GET
	List<CountryResponse> getCountries(@QueryParam("countryCode") String countryCode, @QueryParam("name") String name);
}
