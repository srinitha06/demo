package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    @Override

public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        /*3 THINGS
        1.LOADING A DATA FROM DATA BASE
        2.SETTING UP AUTHORITY
        3.RETURNING UP PROPER USER DETAILS
         */
        //step 1
        RegisterDetails user = registerDetailsRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        //step 2
        Set<GrantedAuthority> authorities=user.getRoles().stream()
                .map(roles-> new SimpleGrantedAuthority(roles.getRoleName()))
                .collect(Collectors.toSet());
        System.out.println(("username is"+user.getUserName()+"\npassword is"+user.getPassword()));
    return new User(user.getUserName(),user.getPassword(),authorities);

}
}

