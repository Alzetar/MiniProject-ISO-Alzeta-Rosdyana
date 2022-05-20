package com.Alterra.ISO.SpringSecurity.Controller;

import com.Alterra.ISO.Model.Obat;
import com.Alterra.ISO.SpringSecurity.DTO.TokenResponse;
import com.Alterra.ISO.SpringSecurity.DTO.UsernamePassword;
import com.Alterra.ISO.SpringSecurity.Model.User;
import com.Alterra.ISO.SpringSecurity.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req){
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody UsernamePassword req){
        TokenResponse token = authService.generateToken(req);
        Map<String, Object> response = new HashMap<>();
        response.put("data", token);
        return ResponseEntity.ok(response);
    }

}
