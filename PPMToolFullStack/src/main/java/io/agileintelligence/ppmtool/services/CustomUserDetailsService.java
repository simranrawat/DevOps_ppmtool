package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger= LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("[loadUserByUsername] - "+username);
        User user = userRepository.findByUsername(username);
        if(user==null) new UsernameNotFoundException("User not found");
        logger.info("[RESULT - loadUserByUsername] - "+user.toString());
        return user;
    }


    @Transactional
    public User loadUserById(Long id){
    	logger.info("[loadUserById] - "+id);
        User user = userRepository.getById(id);
        if(user==null) new UsernameNotFoundException("User not found");
        logger.info("[RESULT - loadUserById] - "+user.toString());
        return user;

    }
}
