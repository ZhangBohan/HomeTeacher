package com.jiajiaohello.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
public class AccountDaoImplTest {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setUsername("bohan");
        account.setPassword("123456");
        accountDao.saveOrUpdate(account);
    }

    @Test
    public void testList() {
        for (Account account : accountDao.list()) {
            System.out.println("account:" + account);
        }

    }

    @Test
    public void testGet() {
        Account account = accountDao.get("bohan");
        System.out.println(account);
        assertNotNull(account);

        account = accountDao.get("bohan1");
        System.out.println(account);
        assertNull(account);
    }
}