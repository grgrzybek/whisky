package org.roeland.whisky.wname;


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

    Map<Long, WhiskyName> bottles = new HashMap<Long, WhiskyName>();

    private @Resource MessageContext jaxrsContext;

    public Service() {
        init();
    }

    @GET
    @Path("/{id}/")
    @Produces("application/xml")
    @ApiOperation(value = "Find WhiskyName name by ID", notes = "More notes about this method", response = WhiskyName.class)
    @ApiResponses(value = {
      @ApiResponse(code = 500, message = "Invalid ID supplied"),
      @ApiResponse(code = 204, message = "WhiskyName not found")
    })
    public WhiskyName getBottle(@ApiParam(value = "ID of WhiskyName to fetch", required = true) @PathParam("id") String id) {
        LOG.info("Invoking getBottle, WhiskyName id is: {}", id);
        long idNumber = Long.parseLong(id);
        WhiskyName b = bottles.get(idNumber);
        return b;
    }

    final void init() {
        WhiskyName b1 = new WhiskyName();
        b1.setName("Talisker 57");
        b1.setId(1);
        bottles.put(b1.getId(), b1);

        WhiskyName b2 = new WhiskyName();
        b2.setName("Highland Park 21");
        b2.setId(2);
        bottles.put(b2.getId(), b2);

    }

}
