package com.jiajiaohello.core.audit.service;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.audit.model.AuditStatus;
import com.jiajiaohello.core.audit.model.IdentityAudit;
import com.jiajiaohello.support.core.CommonDao;
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
    private CommonDao<IdentityAudit> identityAuditCommonDao;

    @Override
    public void pass(Integer auditId, String message) {
        updateStatus(auditId, AuditStatus.pass, message);
    }

    @Override
    public void pass(Integer auditId) {
        pass(auditId, null);
    }

    @Override
    public void reject(Integer auditId, String message) {
        updateStatus(auditId, AuditStatus.reject, message);
    }

    @Override
    public void reject(Integer auditId) {
        reject(auditId, null);
    }

    @Override
    public List<IdentityAudit> getIdentityAuditList(Pager pager, AuditStatus status) {
        IdentityAudit audit = new IdentityAudit();
        audit.setStatus(status.getId());
        return identityAuditCommonDao.getList(audit, pager.getOffset(), pager.getSize());
    }

    private void updateStatus(Integer auditId, AuditStatus status, String message) {
        IdentityAudit audit = identityAuditCommonDao.get(auditId, IdentityAudit.class);
        audit.setStatus(status.getId());
        audit.setMessage(message);
        identityAuditCommonDao.saveOrUpdate(audit);
    }

    @Override
    public void create(Integer teacherId) {
        IdentityAudit audit = new IdentityAudit();
        audit.setStatus(AuditStatus.open.getId());
        TeacherAccount teacherAccount = new TeacherAccount();
        teacherAccount.setId(teacherId);
        audit.setTeacher(teacherAccount);

        // 关闭当前打开的审核
        for (IdentityAudit identityAudit : identityAuditCommonDao.getList(audit)) {
            identityAudit.setStatus(AuditStatus.close.getId());
            identityAuditCommonDao.saveOrUpdate(identityAudit);
        }

        audit.init();
        identityAuditCommonDao.saveOrUpdate(audit);
    }
}
