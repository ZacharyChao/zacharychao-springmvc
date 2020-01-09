package com.zacharychao.user.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zacharychao.user.entity.User;
import com.zacharychao.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc.xml")
public class UserTest {
 
    @Autowired
    private UserService userService;
 
    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("zzk123");
        user.setPassword("123456");
        assertEquals(true, userService.register(user));
    }
 
}