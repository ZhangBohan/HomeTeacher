package com.jiajiaohello.account.dao;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.account.AccountService;
import com.jiajiaohello.account.model.Account;
import com.jiajiaohello.account.model.TeacherAccount;
import com.jiajiaohello.account.model.UserAccount;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AccountDaoTest extends BaseTest {

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private TeacherAccountDao teacherAccountDao;

    @Test
    public void testSaveOrUpdate() throws Exception {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("伯函");
        userAccount.setUsername("bohan");
        userAccount.setPassword("123456");
        userAccountDao.saveOrUpdate(userAccount);
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