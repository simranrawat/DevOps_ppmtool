package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomUserDetailsServiceTest {
    @Autowired
    CustomUserDetailsService cu;
    @Autowired
    private UserService us;

    @Test
    @Transactional
    @Rollback(true)
    public void loadUserById() {
        User u=new User();
        u.setUsername("user69@gmail.com");
        u.setPassword("pass");
        u.setFullName("userfullname");
        u=us.saveUser(u);

        long uid= u.getId();
        User newuser=cu.loadUserById(uid);

        String expected=u.getFullName();
        String actual=newuser.getFullName();
        assertEquals("check loaduserbyid",expected,actual);

    }
}