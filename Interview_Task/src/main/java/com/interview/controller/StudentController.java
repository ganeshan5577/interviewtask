package com.interview.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.interview.model.Student;
import com.interview.service.StudentService;


@Component
@Path("/student")
public class StudentController {
	
	@Autowired
	@Qualifier("StudentService")
	private StudentService studentService;

	@POST
    @Path("/add")
    @Produces("applicaton/json")
	@Consumes("application/json")
	public Response addStudent(@RequestBody Student student) {
 
		long id = studentService.save(student);
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	
	@GET
    @Path("/list")
    @Produces("applicaton/json")
	@Consumes("application/json")
	public Response getStudents() {
 
		List<Student> listOfStudent = studentService.list();
		return Response.status(Response.Status.OK).entity(listOfStudent).build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("id") Long id, Student student) 
	{
		
		studentService.update(id,student);
		 return Response.status(Response.Status.OK).entity(id).build();
	}
    	 
	@GET
	@Path("/")
    public String getMsg()
    {
	 System.out.println("called methods111");
         return "Hello World !! - Jersey 2";
    }

}
