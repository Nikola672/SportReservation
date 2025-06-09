package restClient;

import java.util.List;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.CountryClient;
import model.client.HolidayClient;

@Path("/api/v3")
@RegisterRestClient(configKey ="nager-api")
public interface DateClient {

	@GET
    @Path("/availableCountries")
    List<CountryClient> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    public List<HolidayClient> getNextPublicHolidays(@PathParam("countryCode") String code);
    
}