package com.arangoDemo.dddCqrs.auth.repository;

import com.arangoDemo.dddCqrs.auth.model.RolePermissionReference;
import com.arangodb.springframework.repository.ArangoRepository;

public interface RolePermissionReferenceRepository extends ArangoRepository<RolePermissionReference, String> {
}
