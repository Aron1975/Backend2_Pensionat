package com.backend2.pensionat.repos;

import com.backend2.pensionat.models.Bokning;
import com.backend2.pensionat.models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BokningRepo extends JpaRepository<Bokning, Long> {

    @Query("select kund from Bokning")
    public List<Kund> getKundIdList();

    //@Query("SELECT b FROM Bokning b WHERE b.kund IS NULL")
    //List<Bokning> getNullBokning();


}
