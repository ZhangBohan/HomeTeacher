package com.jiajiaohello.core.ticket;

import com.jiajiaohello.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassTicketServiceTest extends BaseTest {
    @Autowired
    private ClassTicketService classTicketService;

    private ClassTicket classTicket;

    @Before
    public void setUp() throws Exception {
        classTicket = new ClassTicket();
        classTicket.setDescription("东城区");
        classTicket.getCourse().setId(1);
    }

    @Test
    public void testCreate() throws Exception {
        classTicketService.create(classTicket, "15241205228");
    }

    @Test
    public void testProcess() throws Exception {
        classTicketService.process(2, TicketStatus.editorConfirm, "测试", "18511870281");
    }
}