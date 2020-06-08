package com.example.test;

import com.example.HelloWorldResource;
import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TestHelloWorldResource extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(HelloWorldResource.class);
    }

    @Test
    public void testSelect() {
        HelloWorldResource helloWorldResource = CDI.current().select(HelloWorldResource.class).get();
        assertNotNull(helloWorldResource);
    }

}
