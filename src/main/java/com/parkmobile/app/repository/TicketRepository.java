package com.parkmobile.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parkmobile.app.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	Ticket findByToken(String token);
}
