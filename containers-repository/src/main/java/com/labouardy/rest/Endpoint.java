package com.labouardy.rest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.labouardy.entity.Container;
import com.labouardy.service.ContainerService;

@Path("/containers")
@Component
public class Endpoint {
	
	private Logger logger = LoggerFactory.getLogger(Endpoint.class);
	
	@Autowired
	private ContainerService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Container> getContainers(){
		return service.containers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(@RequestBody Container container){
		service.create(container);
	}

	@DELETE
	public Response delete(@QueryParam("id") int id){
		service.delete(Long.valueOf(id));
		return Response.status(200).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@RequestBody Container container){
		service.update(container);
		return Response.status(200).build();
	}
	

}
