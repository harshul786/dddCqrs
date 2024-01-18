package com.arangoDemo.dddCqrs.auth.repository;

import com.arangoDemo.dddCqrs.auth.model.UserReference;
import com.arangodb.springframework.repository.ArangoRepository;

public interface UserReferenceRepository extends ArangoRepository<UserReference, String> {
}
