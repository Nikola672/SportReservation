package model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.inject.Inject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.bar_service;

@Entity
@Path("/e")
public class Employee extends PanacheEntity {

	private String name;

	public Employee(String name) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Employee() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "bar_id", nullable = false)
	private Bar bar;

	@POST
	@Path("/empAdd")
	@Transactional
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployee(@QueryParam("name") String name, @QueryParam("barId") Long barId) {
		Bar bar = Bar.findById(barId);
		if (bar == null) {
			return "bar not found.";
		}

		Employee e = new Employee();
		e.name = name;
		e.bar = bar;
		e.persist();

		return "Employee " + name + " added to bar " + bar.getName();
	}

}

