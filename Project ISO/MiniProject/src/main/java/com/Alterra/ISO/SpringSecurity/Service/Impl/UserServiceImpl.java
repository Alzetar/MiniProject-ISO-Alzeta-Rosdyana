package com.Alterra.ISO.SpringSecurity.Service.Impl;

import com.Alterra.ISO.SpringSecurity.Model.User;
import com.Alterra.ISO.SpringSecurity.Repository.UserRepository;
import com.Alterra.ISO.SpringSecurity.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getDistinctTopByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username Not Found");
        return user;
    }

}
