package org.roeland.whisky.wprice;


import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Path("/")
@Api(value = "/", description = "Operations about get")
public class Service {

    private static final Logger LOG = LoggerFactory.getLogger(Service.class);

    Map<Long, WhiskyPrice> prices = new HashMap<Long, WhiskyPrice>();

    private @Resource MessageContext jaxrsContext;

    public Service() {
        init();
    }

    @GET
    @Path("/{id}/")
    @Produces("application/json")
    @ApiOperation(value = "Find Bottle price by ID", notes = "More notes about this method", response = WhiskyPrice.class)
    @ApiResponses(value = {
      @ApiResponse(code = 500, message = "Invalid ID supplied"),
      @ApiResponse(code = 204, message = "Bottle not found") 
    })
    public WhiskyPrice getPrice(@ApiParam(value = "ID of Bottle to fetch", required = true) @PathParam("id") String id) {
        LOG.info("Invoking getPrice, Bottle id is: {}", id);
        long idNumber = Long.parseLong(id);
        WhiskyPrice p = prices.get(idNumber);
        return p;
    }

    final void init() {
        WhiskyPrice p1 = new WhiskyPrice();
        p1.setPrice("60 euro");
        p1.setId(1);
        prices.put(p1.getId(), p1);

        WhiskyPrice p2 = new WhiskyPrice();
        p2.setPrice("100 euro");
        p2.setId(2);
        prices.put(p2.getId(), p2);

    }

}
