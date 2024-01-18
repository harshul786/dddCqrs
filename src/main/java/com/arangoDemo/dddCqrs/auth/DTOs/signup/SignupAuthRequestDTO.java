package com.arangoDemo.dddCqrs.auth.DTOs.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupAuthRequestDTO {
    private String email;
    private String username;
    private String password;

    List<String> roles;
}
