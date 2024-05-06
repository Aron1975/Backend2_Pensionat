package com.backend2.pensionat;


import com.backend2.pensionat.controllers.KundController;
import com.backend2.pensionat.dtos.DetailedKundDto;
import com.backend2.pensionat.repos.KundRepo;
import com.backend2.pensionat.services.impl.KundServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//testa anrop i controller, och mockdata i service?  //icke fungerande nu...

@SpringBootTest
@AutoConfigureMockMvc
public class KundControllerTestDeep {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private KundServiceImpl mockKundService;

    @MockBean
    private KundRepo mockKundRepo;

    @MockBean
            private KundController kController;

    List<DetailedKundDto> expectedResponseList = new ArrayList<>();

   // @MockBean
   // DetailedKundDto mockKund = new DetailedKundDto();

    /*
    private long id;
    private String ssn;
    private String förnamn;
    private String efternamn;
    private String mobilnummer;
    private String email;
    private String adress;
    private String stad;


    public Kund(String stad, String adress, String email, String mobilnummer, String efternamn, String förnnamn, String ssn) {
        this.stad = stad;
        this.adress = adress;
        this.email = email;
        this.mobilnummer = mobilnummer;
        this.efternamn = efternamn;
        this.förnamn = förnnamn;
        this.ssn = ssn;
    }
     */

    /*
    private long id;
    private String ssn;
    private String förnamn;
    private String efternamn;
    private String adress;
    private String stad;
    private String mobilnummer;
    private String email;
     */

 /*
    @BeforeEach  //används icke just nu
    public void init() {  //kanske har mockdata för service istället? controller går ju mot service
        Kund k1 = new Kund("Huddinge", "Stockholmsvägen 23",
                "karlsson@hotmail.com", "0762272212", "Karlsson", "Karl", "12345");
        Kund k2 = new Kund("Tungelsta", "Vretavägen 22",
                "hotmail@hotmail.com", "076222233", "Levi", "Maja", "54321");
        k1.setId(1L);
        k2.setId(2L);


        mockKund.setId(1L);
        mockKund.setSsn("123");
        mockKund.setFörnamn("hej");
        mockKund.setEfternamn("där");
        mockKund.setEmail("email@email.com");
        mockKund.setAdress("stad 34");
        mockKund.setMobilnummer("321");
        mockKund.setStad("huddinge");

        expectedResponseList = Arrays.asList(new DetailedKundDto(k1), new DetailedKundDto(k2));

        when(mockKundRepo.findById(1L)).thenReturn(Optional.of(k1));
        when(mockKundRepo.findById(2L)).thenReturn(Optional.of(k2));
        when(mockKundRepo.findAll()).thenReturn(Arrays.asList(k1, k2));
        when(mockKundService.getAllKunder()).thenReturn(expectedResponseList);
    }
    */

/*
    @RequestMapping("/all")
    public String getAllKunder(Model model) {
        List<DetailedKundDto> responseList = kundService.getAllKunder();
        model.addAttribute("responseList", responseList);
        model.addAttribute("kat", "kunder");
        model.addAttribute("titel", "Kund");
        return "/allaKunder";
    }
 */
    @Test  //testar om getAllKunder returnerar rätt view
    void getAllKunder() throws Exception {

        this.mvc.perform(get("/kund/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("/allaKunder"))
                .andExpect(model().attributeExists("responseList"))
                .andExpect(model().attributeExists("kat"))
                .andExpect(model().attributeExists("titel"))
                .andExpect(model().attribute("responseList", expectedResponseList))
                .andExpect(model().attribute("kat", "kunder"))
                .andExpect(model().attribute("titel", "Kund"));
    }

}
