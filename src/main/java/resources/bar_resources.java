package resources;

import model.Bar;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import services.bar_service;
import services.bar_service;
import jakarta.inject.Inject;

@Path("/bar")
@Consumes(MediaType.APPLICATION_JSON) // Accepts JSON input
@Produces(MediaType.APPLICATION_JSON)
public class bar_resources {

	@Inject
	bar_service bs;

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBars() {
		return bs.getAllBars().toString();
	}

}
