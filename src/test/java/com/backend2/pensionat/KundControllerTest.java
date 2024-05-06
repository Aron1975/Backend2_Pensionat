package com.backend2.pensionat;

import com.backend2.pensionat.controllers.KundController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KundControllerTest {


    @Autowired
    private KundController kController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value="${local.server.port}")
    private int port;

    @Test
    public void contextLoads() throws Exception {               //testar att kundcontrollern ej är null
        assertThat(kController).isNotNull();


    }

    @Test     //testar komma åt sidan, och att "välkommen till pensionatet" verkligen finns i indexsidan
    public void callKundController() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Välkommen till Pensionatet!");
    }
}