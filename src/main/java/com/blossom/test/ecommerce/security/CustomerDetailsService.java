package com.blossom.test.ecommerce.security;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService  {
    @Autowired
    private UserRepository userRepository;

    private User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = userRepository.findByName(username);

        if(!Objects.isNull(userDetail)){
            return new org.springframework.security.core.userdetails.User(userDetail.getName(),userDetail.getPassword(),new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    public User getUserDetail(){
        return userDetail;
    }
}
