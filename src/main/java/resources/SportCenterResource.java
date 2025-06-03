package resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.SportCenter;
import repository.SportCenterRepository;

@Path("/SportCenter/")
public class SportCenterResource {

	@Inject
	private SportCenterRepository SCRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createSportCenter")
	public Response createSC(SportCenter s) {
		SportCenter sc = SCRepository.createSC(s);
		return Response.ok().entity(sc).build();
	}

	

}