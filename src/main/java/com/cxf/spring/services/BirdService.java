package com.cxf.spring.services;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cxf.spring.model.Bird;
import com.salttest.utility.PageSupportor;

@WebService(serviceName = "birdServices")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface BirdService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/birds/{id}")
    public Response getBirdsById(@PathParam("id") String id);

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/birds")
    public PageSupportor<Bird> getAllBirds();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/birds")
    public Response saveBird( Bird bird);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/birds/{id}")
    public Response deleteBirdsById(@PathParam("id") String id);

}
