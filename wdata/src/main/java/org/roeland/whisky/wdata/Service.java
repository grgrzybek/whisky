package org.roeland.whisky.wdata;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

@Path("/")
public class Service {
    @GET
    @Path("/get/{id}/")
    @Produces({"application/xml", "application/json"})
    public Response getBottleDataResponse(@PathParam("id") String id) {
        return null;
    }


}
