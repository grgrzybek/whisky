package org.roeland.whisky.wdata;

import javax.ws.rs.*;
import org.roeland.whisky.wdata.remote.WhiskyPrice;

@Path("/")
public interface RemoteWhiskyPriceService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public WhiskyPrice getPrice(@PathParam("id") String id);

}
