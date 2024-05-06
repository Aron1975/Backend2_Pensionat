package com.backend2.pensionat;


import com.backend2.pensionat.dtos.RumDto;
import com.backend2.pensionat.models.Rum;
import com.backend2.pensionat.repos.RumRepo;
import com.backend2.pensionat.services.impl.RumServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RumServiceImplTest {



    @Mock
    private RumRepo rumRepo;

    private final RumServiceImpl rumService = new RumServiceImpl(rumRepo);


/*
public Rum(int nummer, int storlek, String typ, int kapacitet, double pris) {
        this.nummer = nummer;
        this.storlek = storlek;
        this.typ = typ;
        this.kapacitet = kapacitet;
        this.pris = pris;
    }
 */

    /* test av följande

    public RumDto rumToRumDto(Rum r) {
        return RumDto.builder().id(r.getId()).nummer(r.getNummer()).rumTyp(r.getTyp()).storlek(r.getStorlek()).kapacitet(r.getKapacitet()).pris(r.getPris()).build();
    }
     */

    @Test
    void testRumtoRumDto() {

       // Rum rum = new Rum(3, 20, "Dubbelrum", 3, 500);
        Rum rum = Rum.builder().nummer(1).storlek(10).typ("Enkelrum").kapacitet(1).pris(500).build();
        rum.setId(2);

        RumDto rumDto = rumService.rumToRumDto(rum);

        assertEquals(rum.getId(), rumDto.getId());
        assertEquals(rum.getNummer(), rumDto.getNummer());
        assertEquals(rum.getTyp(), rumDto.getRumTyp());
        assertEquals(rum.getStorlek(), rumDto.getStorlek());
        assertEquals(rum.getKapacitet(), rumDto.getKapacitet());
        assertEquals(rum.getPris(), rumDto.getPris());




    }



}
