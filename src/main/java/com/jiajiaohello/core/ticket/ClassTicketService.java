package com.jiajiaohello.core.ticket;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 4:09 PM
 */
public interface ClassTicketService {
    void create(ClassTicket ticket, String username);

    void process(Integer ticketId, TicketStatus status, String note, String username);
}
