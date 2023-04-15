package com.kodcu.javaday.repository;

import com.kodcu.javaday.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends TicketRepository<Individual, Long> {
}