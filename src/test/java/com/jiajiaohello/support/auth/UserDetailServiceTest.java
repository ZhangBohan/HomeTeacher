package com.jiajiaohello.support.auth;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.*;

public class UserDetailServiceTest extends BaseTest {
    @Autowired private UserDetailService userDetailService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        UserDetails user = userDetailService.loadUserByUsername("bohan");
        System.out.println(user);
        assertNotNull(user);
    }
}