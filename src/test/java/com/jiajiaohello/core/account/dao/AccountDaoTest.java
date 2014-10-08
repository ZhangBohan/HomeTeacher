package com.jiajiaohello.core.account.dao;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.area.Area;
import com.jiajiaohello.support.auth.PasswordEncoder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.Assert.*;

public class AccountDaoTest extends BaseTest {

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private TeacherAccountDao teacherAccountDao;

    @Test
    public void testSaveOrUpdate() throws Exception {
        TeacherAccount userAccount = new TeacherAccount();
        userAccount.setName("伯函");
        userAccount.setUsername("bohan");
        userAccount.setPassword(new PasswordEncoder().encode("123456"));
        Area area = new Area();
        area.setId(1);
        userAccount.setAreas(Collections.singletonList(area));
        teacherAccountDao.saveOrUpdate(userAccount);
    }

    @Test
    public void testGet() throws Exception {
        UserAccount userAccount = userAccountDao.get(new UserAccount("bohan"));
        System.out.println(userAccount);
        assertNotNull(userAccount);
        TeacherAccount teacherAccount = teacherAccountDao.get(new TeacherAccount("bohan"));
        System.out.println(teacherAccount);
        assertNull(teacherAccount);
    }

    @Test
    public void testList() throws Exception {
    }

    @Test
    public void testList1() throws Exception {

    }
}