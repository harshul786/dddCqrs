package com.arangoDemo.dddCqrs.auth.service;

import com.arangoDemo.dddCqrs.auth.DTOs.JwtResponseDTO;
import com.arangoDemo.dddCqrs.auth.DTOs.signin.SignInAuthRequestDTO;
import com.arangoDemo.dddCqrs.auth.DTOs.signup.SignupAuthRequestDTO;

public interface AuthenticationService {
    JwtResponseDTO signup(SignupAuthRequestDTO request);

    JwtResponseDTO signin(SignInAuthRequestDTO request);
}