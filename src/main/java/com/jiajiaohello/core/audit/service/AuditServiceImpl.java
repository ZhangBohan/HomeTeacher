package com.jiajiaohello.core.audit.service;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.audit.dao.IdentityAuditDao;
import com.jiajiaohello.core.audit.model.AuditStatus;
import com.jiajiaohello.core.audit.model.IdentityAudit;
import com.jiajiaohello.support.web.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: bohan
 * Date: 11/8/14
 * Time: 3:51 PM
 */
@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    private IdentityAuditDao identityAuditDao;

    @Override
    public void pass(Integer auditId, String message) {
        // TODO
    }

    @Override
    public void pass(Integer auditId) {
        pass(auditId, null);
    }

    @Override
    public void reject(Integer auditId, String message) {
        // TODO
    }

    @Override
    public void reject(Integer auditId) {
        reject(auditId, null);
    }

    @Override
    public List<IdentityAudit> getIdentityAuditList(Pager pager, AuditStatus status) {
        IdentityAudit audit = new IdentityAudit();
        audit.setStatus(status.getId());
        return identityAuditDao.getList(audit, pager.getOffset(), pager.getSize());
    }

    @Override
    public void create(Integer teacherId) {
        IdentityAudit audit = new IdentityAudit();
        audit.init();
        audit.setStatus(AuditStatus.open.getId());
        TeacherAccount teacherAccount = new TeacherAccount();
        teacherAccount.setId(teacherId);
        audit.setTeacher(teacherAccount);
        identityAuditDao.saveOrUpdate(audit);
    }
}
