package org.itai.inventory.rest.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.itai.inventory.rest.InventoryResource;

public class InventoryApplication extends Application
{
    Set<Object> singletons = new HashSet<>();
    Set<Class<?>> classes = Collections.emptySet();

    public InventoryApplication()
    {
        InventoryResource ir = new InventoryResourceImpl();
        this.singletons.add(ir);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return this.classes;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return this.singletons;
    }
}
