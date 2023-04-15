package com.kodcu.javaday.repository;

import com.kodcu.javaday.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends TicketRepository<Company, Long> {
}