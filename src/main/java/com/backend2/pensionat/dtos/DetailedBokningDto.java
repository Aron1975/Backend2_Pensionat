package com.backend2.pensionat.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedBokningDto {

    private long id;

    @NotNull(message = "Bokningsdatum får inte vara null.")
    @FutureOrPresent(message = "Bokningsdatum måste vara idag eller i framtiden.")
    private LocalDate bokningsDatum;

    @NotNull(message = "Startdatum får inte vara null.")
    @FutureOrPresent(message = "Startdatum måste vara idag eller i framtiden.")
    private LocalDate startDatum;

    @NotNull(message = "Slutdatum får inte vara null.")
    private LocalDate slutDatum;

    @Min(value = 1, message = "Antal gäster måste vara minst 1.")
    private int antalGäster;

    @Min(value = 0, message = "Antal extrasängar kan inte vara mindre än 0.")
    private int antalExtraSängar;

    @Positive(message = "Totalpriset måste vara positivt.")
    private double totalPris;

    private KundDto kund;

    private RumDto rum;
}
