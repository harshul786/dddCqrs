package com.arangoDemo.dddCqrs.character.infrastructure.repository.write;

import com.arangoDemo.dddCqrs.character.domain.write_model.Character;
import com.arangodb.springframework.repository.ArangoRepository;

public interface CharacterRepository extends ArangoRepository<Character, String> {
}
