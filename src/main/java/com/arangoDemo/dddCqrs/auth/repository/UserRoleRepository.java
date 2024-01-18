package com.arangoDemo.dddCqrs.auth.repository;

import com.arangoDemo.dddCqrs.auth.model.UserRole;
import com.arangodb.springframework.repository.ArangoRepository;

public interface UserRoleRepository extends ArangoRepository<UserRole, String> {
    public UserRole findByName(String Name);

}
