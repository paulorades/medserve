package org.tiddy.fhir.server;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ca.uhn.fhir.model.dstu2.resource.Medication;

@Path("/Medication")
public class Server {

	@Inject
	MedicationStore store;

	@GET
	@Path("/getAll")
	@Produces({ "application/json" })
	public List<Medication> getAll() {
		store.add(new Medication());
		store.search();
		return Arrays.asList();
	}

	@GET
	@Path("/_search")
	@Produces({ "application/json" })
	public List<Medication> search(@QueryParam("_id") String id) {
		store.search();
		Medication m = new Medication();
		return Arrays.asList(m);
	}

	@PUT
	@Path("/")
	@Produces({ "application/json" })
	public void create(Medication m) {
		// consume m
	}

}