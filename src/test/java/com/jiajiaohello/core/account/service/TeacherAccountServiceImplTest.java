package com.jiajiaohello.core.account.service;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class TeacherAccountServiceImplTest extends BaseTest {
    @Autowired
    private TeacherAccountService teacherAccountService;

    @Test
    public void testGetRecommendTeacherAccounts() throws Exception {
        List<TeacherAccount> recommendTeacherAccounts = teacherAccountService.getRecommendTeacherAccounts(RecommendType.top, 0, 10);
        System.out.println(recommendTeacherAccounts);
        assertNotNull(recommendTeacherAccounts);
    }
}