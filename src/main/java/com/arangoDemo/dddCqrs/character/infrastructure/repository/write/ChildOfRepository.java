package com.arangoDemo.dddCqrs.character.infrastructure.repository.write;

import com.arangoDemo.dddCqrs.product.domain.write_model.ChildOf;
import com.arangodb.springframework.repository.ArangoRepository;

public interface ChildOfRepository extends ArangoRepository<ChildOf, String> {
}
