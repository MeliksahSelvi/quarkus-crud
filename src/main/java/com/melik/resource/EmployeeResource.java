package com.melik.resource;

import com.melik.domain.Employee;
import com.melik.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @Author mselvi
 * @Created 19.02.2024
 */

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    public Response findAll() {
        return Response.ok(employeeService.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response findEmployeeById(@PathParam("id") Long id) {
        return Response.ok(employeeService.findById(id)).build();
    }

    @POST
    public Response persistEmployee(Employee employee) {
        employeeService.persistEmployee(employee);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response updateBook(Employee employee) {
        return Response.ok(employeeService.updateBook(employee)).build();
    }
}
