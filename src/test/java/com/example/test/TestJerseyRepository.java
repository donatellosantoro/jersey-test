package com.example.test;

import com.example.UserRepository;
import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TestJerseyRepository extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(UserRepository.class);
    }

    @Test
    public void testSelect() {
        UserRepository userRepository = CDI.current().select(UserRepository.class).get();
        assertNotNull(userRepository);
    }

}
