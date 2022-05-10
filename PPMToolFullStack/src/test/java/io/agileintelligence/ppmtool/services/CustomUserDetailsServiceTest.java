package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
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
        u.setUsername("simran@gmail.com");
        u.setPassword("pass");
        u.setFullName("simran");
        u=us.saveUser(u);

        long uid= u.getId();
        User newuser=cu.loadUserById(uid);

        String expected=u.getFullName();
        String actual=newuser.getFullName();
        assertEquals("check loaduserbyid",expected,actual);




        User u2=new User();
        u2.setUsername("sim@gmail.com");
        u2.setPassword("pass");
        u2.setFullName("sim");
        u2=us.saveUser(u2);

        long uid2= u2.getId();
        User newuser2=cu.loadUserById(uid2);

        String expected2=u2.getFullName();
        String actual2=newuser2.getFullName();
        assertEquals("check loaduserbyid",expected2,actual2);


        User u3=new User();
        u3.setUsername("akshita@gmail.com");
        u3.setPassword("pass");
        u3.setFullName("akshita");
        u3=us.saveUser(u3);

        long uid3= u3.getId();
        User newuser3=cu.loadUserById(uid3);

        String expected3=u3.getFullName();
        String actual3=newuser3.getFullName();
        assertEquals("check loaduserbyid",expected3,actual3);


        User u4=new User();
        u4.setUsername("akshitamingwal@gmail.com");
        u4.setPassword("pass");
        u4.setFullName("akshita mingwal");
        u4=us.saveUser(u4);

        long uid4= u4.getId();
        User newuser4=cu.loadUserById(uid4);

        String expected4=u4.getFullName();
        String actual4=newuser4.getFullName();
        assertEquals("check loaduserbyid",expected4,actual4);


        User u5=new User();
        u5.setUsername("sivans@gmail.com");
        u5.setPassword("password");
        u5.setFullName("sivans rawat");
        u5=us.saveUser(u5);

        long uid5= u5.getId();
        User newuser5=cu.loadUserById(uid5);

        String expected5=u5.getFullName();
        String actual5=newuser5.getFullName();
        assertEquals("check loaduserbyid",expected5,actual5);

        User u6=new User();
        u6.setUsername("ananya@gmail.com");
        u6.setPassword("pass");
        u6.setFullName("ananya bisht");
        u6=us.saveUser(u6);

        long uid6= u6.getId();
        User newuser6=cu.loadUserById(uid6);

        String expected6=u6.getFullName();
        String actual6=newuser6.getFullName();
        assertEquals("check loaduserbyid",expected6,actual6);



        User u7=new User();
        u7.setUsername("ananyabisht@gmail.com");
        u7.setPassword("password");
        u7.setFullName("ananya");
        u7=us.saveUser(u7);

        long uid7= u7.getId();
        User newuser7=cu.loadUserById(uid7);

        String expected7=u7.getFullName();
        String actual7=newuser7.getFullName();
        assertEquals("check loaduserbyid",expected7,actual7);

    }



}