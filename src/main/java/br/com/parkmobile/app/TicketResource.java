package br.com.parkmobile.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketResource {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/tickets")
    public List<Ticket> retrieveAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/tickets/{id}")
    public Ticket retrieveTicket(@PathVariable long id) throws TicketNotFoundException {

        Optional<Ticket> ticket = ticketRepository.findById(id);

        if (!ticket.isPresent()) {
            throw new TicketNotFoundException("id-" + id);
        }

        return ticket.get();
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable long id) {
        ticketRepository.deleteById(id);
    }

    @PostMapping("/tickets")
    public ResponseEntity<Object> createTicket(@RequestBody Ticket ticket) {

        Ticket savedTicket = ticketRepository.save(ticket);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTicket.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<Object> updateTicket(@RequestBody Ticket ticket, @PathVariable long id) {

        Optional<Ticket> ticketOptional = ticketRepository.findById(id);

        if (!ticketOptional.isPresent())
            return ResponseEntity.notFound().build();

        ticket.setId(id);

        ticketRepository.save(ticket);

        return ResponseEntity.noContent().build();
    }
}