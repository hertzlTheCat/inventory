package org.itai.inventory.rest;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/items")
public interface InventoryResource
{
    @POST
    @Consumes("application/xml")
    Response createItem(InputStream is);

    @GET
    @Path("{id}")
    @Produces("application/xml")
    StreamingOutput getItem(@PathParam("id") long id);

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    void updateItem(@PathParam("id") long id, InputStream is);
}
