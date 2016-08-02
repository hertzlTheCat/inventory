package org.itai.inventory.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.itai.inventory.Item;
import org.itai.inventory.impl.SimpleItem;

@Path("/items")
public class InventoryResouce
{
    // TODO change to JSON

    private Map<Long, Item> items;

    public InventoryResouce()
    {
        this.loadItems();
    }

    @POST
    @Consumes("application/xml")
    public void createItem(InputStream is)
    {
        // TODO read is
        Item item = new SimpleItem("dummy", 1);
        items.put(item.getId(), item);

        Response.created(URI.create("/items/" + item.getId())).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public StreamingOutput getCustomer(@PathParam("id") long id)
    {
        Item item = this.items.get(id);
        if (item == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return new StreamingOutput() {
            @Override
            public void write(OutputStream arg0) throws IOException, WebApplicationException {
                // TODO
            }
        };
    }

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void updateItem(@PathParam("id") long id, InputStream is)
    {
        Item item = this.items.get(id);
        if (item == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        // TODO
    }

    private void loadItems()
    {
        Item i1 = new SimpleItem("Pink plasic pig", 1);
        Item i2 = new SimpleItem("Ceramic cups from David", 2);
        this.items = new ConcurrentHashMap<>();
        items.put(i1.getId(), i1);
        items.put(i2.getId(), i2);
    }
}
