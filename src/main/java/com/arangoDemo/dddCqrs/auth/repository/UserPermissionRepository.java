package com.arangoDemo.dddCqrs.auth.repository;

import com.arangoDemo.dddCqrs.auth.model.UserPermission;
import com.arangodb.springframework.repository.ArangoRepository;

import java.util.Optional;

public interface UserPermissionRepository extends ArangoRepository<UserPermission, String> {
    public Optional<UserPermission> findByName(String name);
}
