package com.labouardy.rest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;
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
		logger.info("GET /containers");
		return service.containers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(@RequestBody Container container){
		service.create(container);
	}
	
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Container find(@PathParam("id") Long id){
		return service.find(id);
	}
	

	@Path("/{id}")
	@DELETE
	public void delete(@PathParam("id") Long id){
		service.delete(id);
	}
	

}
