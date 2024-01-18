package com.arangoDemo.dddCqrs.character.presentation.controller;

import com.arangoDemo.dddCqrs.character.domain.write_model.Character;
import com.arangoDemo.dddCqrs.character.infrastructure.messaging.command.CharacterCommandHandler;
import com.arangoDemo.dddCqrs.character.presentation.dto.command.CreateCharacterCommandDto;
import com.arangoDemo.dddCqrs.character.presentation.dto.command.UpdateCharacterCommandDto;
import com.arangoDemo.dddCqrs.shared.dto.CustomResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
public class CharacterCommandController {
    private final CharacterCommandHandler commandHandler;

    @PostMapping
    public ResponseEntity<CustomResponseModel<Character>> createCharacter(@RequestBody CreateCharacterCommandDto characterDto) {
        Character createdCharacter = commandHandler.handle(characterDto);
        return CustomResponseModel.wrapCreateSuccess(createdCharacter);
    }

    @PutMapping
    public ResponseEntity<CustomResponseModel<Character>> updateCharacter(@RequestBody UpdateCharacterCommandDto characterDto) {
        Character updatedCharacter = commandHandler.handle(characterDto);
        return CustomResponseModel.wrapUpdateSuccess(updatedCharacter);
    }
}