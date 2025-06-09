package resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Employee;
import repository.EmployeeRepository;

@Path("/Employee/")
public class EmployeeResource {

	@Inject
	private EmployeeRepository EmployeeRepository;

	@POST
	@Path("/empAdd")
	public Employee addEmployee(@QueryParam("name") String name, @QueryParam("barId") Long barId) {
		return EmployeeRepository.addEmployee(name, barId);
	}

}
