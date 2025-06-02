package resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import restClient.HolidayClient;
import model.client.HolidayResponse;

import java.util.List;

@Path("/holidays")
public class HolidayResource {

    @Inject
    @RestClient
    HolidayClient holidayClient;

    @GET
    @Path("/{year}/{countryCode}")
    public List<HolidayResponse> getHolidays(@PathParam("year") int year, @PathParam("countryCode") String countryCode) {
        return holidayClient.getHolidays(year, countryCode);
    }
}
