package com.arangoDemo.dddCqrs.product.infrastructure.repository.read;

import com.arangoDemo.dddCqrs.character.domain.read_model.CharacterSummary;
import com.arangodb.springframework.repository.ArangoRepository;

public interface CharacterSummaryRepository extends ArangoRepository<CharacterSummary, String> {
}
