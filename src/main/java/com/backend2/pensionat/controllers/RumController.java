package com.backend2.pensionat.controllers;

import com.backend2.pensionat.dtos.RumDto;
import com.backend2.pensionat.repos.BokningRepo;
import com.backend2.pensionat.repos.RumRepo;
import com.backend2.pensionat.services.BokningService;
import com.backend2.pensionat.services.RumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rum")
public class RumController {

    private final RumRepo rumRepo;
    private final RumService rumService;
    private final BokningRepo bokningRepo;
    private final BokningService bokningService;

    @RequestMapping("/all")
    public String allRums(Model model) {
        List<RumDto> responseList = rumService.getAllRum();
        model.addAttribute("responseList", responseList);
        model.addAttribute("kat", "rum");
        model.addAttribute("titel", "Rum");
        return "/allaRum";
    }

    @RequestMapping("/")
    public String start(Model model) {
        model.addAttribute("errorMessage", "Felaktig datumintervall angiven!");
        return "index";
    }

    @RequestMapping("/sök")
    public String findRum(@RequestParam int guests, @RequestParam String startDate, @RequestParam String stopDate, Model model) {

        if(startDate.isBlank() || startDate.isEmpty() || stopDate.isBlank() || stopDate.isEmpty()){
            return "redirect:/rum/";
        }
        LocalDate chin = LocalDate.parse(startDate);
        LocalDate chout = LocalDate.parse(stopDate);
        if(chout.isBefore(chin)||chout.isEqual(chin)){
            return "redirect:/rum/";
        }

        List<RumDto> availableRumByCapacity = rumService.getAvailableRum(guests);
        LocalDate startDatum = LocalDate.parse(startDate);
        LocalDate stopDatum = LocalDate.parse(stopDate);
        List<RumDto> availableRumList = bokningService.getAvailableRumByDate(availableRumByCapacity, startDatum, stopDatum);
        String searchMessage = "";
        //String searchImg = "";
        boolean has_logo = false;
        if(availableRumList.isEmpty()){
            searchMessage = "Rum nicht verfügbar. Keine Stelle frei";
            //searchImg = "/images/moose.jpg";
            has_logo = true;
        }
        model.addAttribute("availableRumList", availableRumList);
        model.addAttribute("startDatum", startDate);
        model.addAttribute("stopDatum", stopDate);
        model.addAttribute("antal", guests);
        model.addAttribute("noAvRumMessage", searchMessage);
        //model.addAttribute("searchImg", searchImg);
        model.addAttribute("has_logo", has_logo);
        return "allaLedigaRum";
    }

    @RequestMapping("/boka/{id}")
    public String findRum(Model model, @PathVariable int id, @RequestParam String startDate, @RequestParam String stopDate, @RequestParam int guests) {
        model.addAttribute("rumId", id);
        model.addAttribute("guests", guests);
        model.addAttribute("startDate", startDate);
        model.addAttribute("stopDate", stopDate);

        return "redirect:/bokning/add";
    }
}
