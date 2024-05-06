package com.backend2.pensionat.services;

import com.backend2.pensionat.dtos.DetailedKundDto;
import com.backend2.pensionat.dtos.KundDto;
import com.backend2.pensionat.models.Kund;


import java.util.List;

public interface KundService {


    
    public List<DetailedKundDto> getAllKunder();

    public DetailedKundDto kundToDetailedKundDto(Kund k);

    public Kund detailedKundDtoToKund(DetailedKundDto k);

    public KundDto kundToKundDto(Kund k);

    public void deleteKundById(long id);

    public String spara(DetailedKundDto k);

    public DetailedKundDto getKund(Integer id);




}
