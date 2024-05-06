package com.backend2.pensionat.repos;

import com.backend2.pensionat.models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundRepo extends JpaRepository<Kund, Long> {
}
