package com.jiajiaohello.core.audit.service;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.audit.model.AuditStatus;
import com.jiajiaohello.core.audit.model.IdentityAudit;
import com.jiajiaohello.support.web.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuditServiceTest extends BaseTest {
    @Autowired
    private AuditService auditService;

    @Test
    public void testPass() throws Exception {
        auditService.pass(3);
    }

    @Test
    public void testPass1() throws Exception {

    }

    @Test
    public void testReject() throws Exception {

    }

    @Test
    public void testReject1() throws Exception {

    }

    @Test
    public void testGetIdentityAuditList() throws Exception {
        List<IdentityAudit> identityAuditList = auditService.getIdentityAuditList(new Pager(), AuditStatus.open);
        System.out.println(identityAuditList);
    }

    @Test
    public void testCreate() throws Exception {
        auditService.create(3);
    }
}