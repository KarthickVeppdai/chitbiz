package com.villagebiz.chit.service;


import com.villagebiz.chit.model.User;
import com.villagebiz.chit.repositories.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String password = request.getParameter("password");
        User user= userRepo.findUserByUsername(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("No user found for "+ username + ".");
        }
        else
        {
            if (new BCryptPasswordEncoder().matches(password,user.getPassword()))
            {
                System.out.println("Inside UserService"+password);
                List<GrantedAuthority> authorities = new ArrayList<>();
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
                authorities.add(authority);
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
            }
            else {
                throw new UsernameNotFoundException("Password wrong for "+ username + ".");
            }

        }
    }
}
