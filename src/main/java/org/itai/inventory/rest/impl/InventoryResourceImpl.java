package org.itai.inventory.rest.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.itai.inventory.Item;
import org.itai.inventory.impl.SimpleItem;
import org.itai.inventory.rest.InventoryResource;

public class InventoryResourceImpl implements InventoryResource
{
    // TODO change to JSON

    private Map<Long, Item> items;

    public InventoryResourceImpl()
    {
        this.loadItems();
    }

    @Override
    public Response createItem(InputStream is)
    {
        System.out.println("create item ");
        return Response.created(URI.create("/items/0")).build();
    }

    @Override
    public StreamingOutput getItem(long id)
    {
        System.out.println("get: " + id);
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

    @Override
    public void updateItem(long id, InputStream is)
    {
        System.out.println("update: " + id);
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
