package com.arangoDemo.dddCqrs.auth.model.enums;

import com.arangoDemo.dddCqrs.auth.model.UserRole;

import java.util.List;
import java.util.Set;

public enum AllowedRoles {
    ADMIN,
    HR,
    USER;

    public static boolean areRolesValid(List<String> roles) {
        for (String role : roles) {
            if (!isValidRole(role)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRole(String role) {
        try {
            valueOf(role);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean areRolesValid(Set<UserRole> roles) {
        return areRolesValid(roles.stream().map(UserRole::getName).toList());
    }
}
