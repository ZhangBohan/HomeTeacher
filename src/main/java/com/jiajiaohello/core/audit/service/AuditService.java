package com.jiajiaohello.core.audit.service;

import com.jiajiaohello.core.audit.model.AuditStatus;
import com.jiajiaohello.core.audit.model.IdentityAudit;
import com.jiajiaohello.support.web.Pager;

import java.util.List;

/**
 * User: bohan
 * Date: 11/8/14
 * Time: 3:39 PM
 */
public interface AuditService {
    void pass(Integer auditId, String message);

    void pass(Integer auditId);

    void reject(Integer auditId, String message);

    void reject(Integer auditId);

    List<IdentityAudit> getIdentityAuditList(Pager pager, AuditStatus status);

    void create(Integer teacherId);
}
