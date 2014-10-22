package org.roeland.whisky.wdata;

import javax.ws.rs.*;
import org.roeland.whisky.wdata.remote.WhiskyName;

@Path("/")
public interface RemoteWhiskyNameService {

    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public WhiskyName getName(@PathParam("id") String id);

}
