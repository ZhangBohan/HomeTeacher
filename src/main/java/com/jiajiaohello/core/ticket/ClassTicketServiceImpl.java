package com.jiajiaohello.core.ticket;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.account.service.AccountService;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.account.service.UserAccountService;
import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.support.core.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 4:24 PM
 */
@Service
public class ClassTicketServiceImpl implements ClassTicketService {
    @Autowired
    private CommonDao<ClassTicket> classTicketCommonDao;
    @Autowired
    private CommonDao<ClassTicketNote> classTicketNoteCommonDao;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TeacherAccountService teacherAccountService;

    @Override
    public void process(Integer ticketId, TicketStatus status, String note, String username) {
        Account account = accountService.get(username);

        ClassTicket classTicket = classTicketCommonDao.get(ticketId, ClassTicket.class);
        // 记录LOG
        ClassTicketNote classTicketNote = new ClassTicketNote();
        classTicketNote.init();
        classTicketNote.setStatus(status.getId());
        classTicketNote.setAccount(account);
        classTicketNote.setNote(note);
        classTicketNoteCommonDao.saveOrUpdate(classTicketNote);
        classTicket.getNotes().add(classTicketNote);
        classTicketCommonDao.saveOrUpdate(classTicket);
    }

    @Override
    public void create(ClassTicketForm classTicketForm, String username) throws ParseException {
        ClassTicket ticket = new ClassTicket();
        ticket.init();
        UserAccount userAccount = userAccountService.get(username);
        ticket.setUserAccount(userAccount);
        ticket.setCourse(new Course(classTicketForm.getCourse()));
        ticket.setDescription(classTicketForm.getAddress());

        ticket.setTeachingAt(classTicketForm.getTeachingDate());
        if(classTicketForm.getTeacherId() != null) {
            ticket.setTeacherAccount(new TeacherAccount(classTicketForm.getTeacherId()));
        }

        classTicketCommonDao.saveOrUpdate(ticket);
    }
}
