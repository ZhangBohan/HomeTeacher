package com.jiajiaohello.support.auth;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.*;

public class UserUserDetailServiceTest extends BaseTest {
    @Autowired private UserUserDetailService userUserDetailService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        UserDetails user = userUserDetailService.loadUserByUsername("bohan");
        System.out.println(user);
        assertNotNull(user);
    }
}