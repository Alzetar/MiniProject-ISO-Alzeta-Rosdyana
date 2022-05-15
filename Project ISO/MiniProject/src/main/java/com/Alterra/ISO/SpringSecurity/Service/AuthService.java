package com.Alterra.ISO.SpringSecurity.Service;


import com.Alterra.ISO.SpringSecurity.DTO.TokenResponse;
import com.Alterra.ISO.SpringSecurity.DTO.UsernamePassword;
import com.Alterra.ISO.SpringSecurity.Model.User;

public interface AuthService {
    User register(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);
}
