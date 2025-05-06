package model;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.inject.Inject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.bar_service;

@Entity
@Path("/bar")
public class Bar extends PanacheEntity {

	private String name;

	
	public Bar() {
	}

	public Bar(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + "]";
	}

	@GET
	@Transactional
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@QueryParam("name") String name) {
		Bar r = new Bar();
		r.name = name;
		r.persist();
		return "Hello " + name;
	}

}
