package com.jiajiaohello.core.ticket;

import java.text.ParseException;
import java.util.List;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 4:09 PM
 */
public interface ClassTicketService {
    void process(Integer ticketId, TicketStatus status, String note, String username);

    void create(ClassTicketForm classTicketForm, String username) throws ParseException;

    List<ClassTicket> getClassTickets(TicketStatus status);
}
