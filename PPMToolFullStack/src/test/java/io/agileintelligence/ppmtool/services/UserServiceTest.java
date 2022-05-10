package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.User;
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
public class UserServiceTest {

    @Autowired
    UserService us;

    @Test
    @Transactional
    @Rollback(true)
    public void saveUser() {
        User u= new User();
        u.setConfirmPassword("simran");
        u.setFullName("Simran Rawat");
        u.setId(1L);
        u.setPassword("simran");
        u.setUsername("rawatsimran2610@gmail.com");

        String expected =u.getFullName();
        User newuser=us.saveUser(u);

        String actual= newuser.getFullName();

        assertEquals("checking save user",expected,actual);

    }
}