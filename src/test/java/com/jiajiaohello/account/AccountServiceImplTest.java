package com.jiajiaohello.account;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AccountServiceImplTest extends BaseTest {
    @Autowired private AccountService accountService;

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        Account account = new Account();
        account.setUsername("admin");
        account.setPassword("123456");
        accountService.save(account);
        System.out.println(account);
    }
}