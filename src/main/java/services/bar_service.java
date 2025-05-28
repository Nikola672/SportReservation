package services;

import java.util.List;
import model.Bar;
import model.SportCenter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/service")
public class bar_service {

	@Inject
	EntityManager em;

	

	
	@POST
	@Path("/addBar")
	@Transactional
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@QueryParam("name") String name, @QueryParam("sportCenterID") long sportCenterId) {
		SportCenter s = SportCenter.findById(sportCenterId);
		if (s == null) {
			return "Nije nista nadjeno";
		}
		Bar r = new Bar();
		r.setName(name);
		r.setSportCenter(s);
		r.persist();
		return "Hello " + name;
	}

	@Transactional
	public List<Bar> getAllBars() {
		return em.createQuery("SELECT b FROM Bar b", Bar.class).getResultList();
	}

}
