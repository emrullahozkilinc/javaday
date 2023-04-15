package com.kodcu.javaday.repository;

import com.kodcu.javaday.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TicketRepository<T extends Ticket, ID extends Serializable> extends JpaRepository<T, ID> {
}
