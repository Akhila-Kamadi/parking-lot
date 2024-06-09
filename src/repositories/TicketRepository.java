package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> tickets = new HashMap<>();
    Long lastCount = 0L;
    public Ticket save(Ticket ticket) {
        lastCount += 1;
        ticket.setId(lastCount);
        tickets.put(lastCount,ticket);
        return ticket;
    }
}
