package org.itai.inventory.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class TestClient
{
    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
        try {
            System.out.println("Create a new item");
            String xml = "<item>textXML</item>";
            Entity<String> xmlEntity = Entity.xml(xml);

            String address = "http://localhost:8080/inventory/items";

            Response response = client.target(address).request().post(xmlEntity);

            System.out.println(response);
            System.out.println(response.getHeaders());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
