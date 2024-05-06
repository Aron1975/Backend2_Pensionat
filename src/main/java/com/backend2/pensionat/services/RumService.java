package com.backend2.pensionat.services;

import com.backend2.pensionat.dtos.RumDto;
import com.backend2.pensionat.models.Rum;

import java.util.List;

public interface RumService {

    public List<RumDto> getAllRum();

    public RumDto rumToRumDto(Rum r);

    public List<RumDto> getAvailableRum(int antal);

    
}
