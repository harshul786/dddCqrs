package com.arangoDemo.dddCqrs.character.infrastructure.messaging.command;

import com.arangoDemo.dddCqrs.character.domain.event.CharacterEvent;
import com.arangoDemo.dddCqrs.character.domain.write_model.Character;
import com.arangoDemo.dddCqrs.character.infrastructure.repository.write.CharacterRepository;
import com.arangoDemo.dddCqrs.character.presentation.dto.command.CreateCharacterCommandDto;
import com.arangoDemo.dddCqrs.character.presentation.dto.command.UpdateCharacterCommandDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CharacterCommandHandler {
    private final CharacterRepository repository;
    private final KafkaTemplate<String, CharacterEvent> kafkaTemplate;

    public Character handle(CreateCharacterCommandDto createCharacterCommandDto) {
        Character character = repository.save(createCharacterCommandDto.toCharacter());

        CharacterEvent event = new CharacterEvent("CharacterCreated", character);
        this.kafkaTemplate.send("characters", event);

        return character;
    }
    public Character handle(UpdateCharacterCommandDto updateCharacterCommandDto) {
        if(repository.findById(updateCharacterCommandDto.getId()).isEmpty()){
            throw new IllegalArgumentException("Character not present!");
        }
        Character character = repository.save(updateCharacterCommandDto.toCharacter());

        CharacterEvent event = new CharacterEvent("CharacterUpdated", character);
        this.kafkaTemplate.send("characters", event);

        return character;
    }

}
