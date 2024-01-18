package com.arangoDemo.dddCqrs.character.infrastructure.repository.read;

import com.arangoDemo.dddCqrs.character.domain.read_model.ChildOfSummary;
import com.arangodb.springframework.repository.ArangoRepository;

public interface ChildOfSummaryRepository extends ArangoRepository<ChildOfSummary, String> {
}
