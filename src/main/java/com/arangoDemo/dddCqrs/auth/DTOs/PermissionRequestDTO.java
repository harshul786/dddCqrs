package com.arangoDemo.dddCqrs.auth.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class PermissionRequestDTO {
    private Set<String> names;
}
