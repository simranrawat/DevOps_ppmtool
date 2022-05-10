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


        User u2= new User();
        u2.setConfirmPassword("pass");
        u2.setFullName("Simran");
        u2.setId(1L);
        u2.setPassword("pass");
        u2.setUsername("simran2610@gmail.com");

        String expected2 =u2.getFullName();
        User newuser2=us.saveUser(u2);

        String actual2= newuser.getFullName();

        assertEquals("checking save user",expected2,actual2);


        User u3= new User();
        u3.setConfirmPassword("simran");
        u3.setFullName("Ananya");
        u3.setId(1L);
        u3.setPassword("simran");
        u3.setUsername("ananya@gmail.com");


        String expected3 =u3.getFullName();
        User newuser3=us.saveUser(u3);

        String actual3= newuser3.getFullName();

        assertEquals("checking save user",expected3,actual3);


        User u4= new User();
        u4.setConfirmPassword("simran");
        u4.setFullName("Sivans Rawat");
        u4.setId(1L);
        u4.setPassword("simran");
        u4.setUsername("sivans@gmail.com");

        String expected4 =u4.getFullName();
        User newuser4=us.saveUser(u4);

        String actual4= newuser4.getFullName();

        assertEquals("checking save user",expected4,actual4);


    }
}