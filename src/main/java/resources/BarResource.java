package resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import model.Bar;
import repository.BarRepository;

@Path("/bars/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BarResource {

    @Inject
    BarRepository barRepository;

    @GET
    @Path("getBars")
    public List<Bar> getBars() {
        return barRepository.getAllBars();
    }

    @POST
    @Path("createBar")
    public Bar createBar(@QueryParam("name") String name, @QueryParam("sportCenterId") long sportCenterId) {
        return barRepository.addBar(name, sportCenterId);
    }
}

