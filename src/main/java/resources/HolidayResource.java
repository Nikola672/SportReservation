package resources;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.client.CountryClient;
import model.client.HolidayClient;
import repository.HolidayRepository;
import restClient.DateClient;

@Path("/holiday/")
public class HolidayResource {
	

    @Inject
    @RestClient
    private DateClient dateClient;

    @Inject
    HolidayRepository holidayRepo;

    @POST
    @Path("/save/{countryCode}")
  
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveHolidays(@PathParam("countryCode") String code) {
        List<HolidayClient> holidays = dateClient.getNextPublicHolidays(code);

        for (HolidayClient res : holidays) {
        	holidayRepo.saveHoliday(res);
        }

        return Response.ok(holidays).build();
    }
    @GET
	@Path("getCountries")
	public Response getCountries() {
		List<CountryClient> country = dateClient.getAvailableCountries();
		return Response.ok().entity(country).build();
	}
}
