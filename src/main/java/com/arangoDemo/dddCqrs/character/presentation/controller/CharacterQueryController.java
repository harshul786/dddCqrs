package com.arangoDemo.dddCqrs.character.presentation.controller;

import com.arangoDemo.dddCqrs.character.domain.read_model.CharacterSummary;
import com.arangoDemo.dddCqrs.character.infrastructure.messaging.query.CharacterQueryHandler;
import com.arangoDemo.dddCqrs.shared.dto.CustomResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
public class CharacterQueryController {
    private final CharacterQueryHandler queryHandler;

    @GetMapping
    public ResponseEntity<CustomResponseModel<List<CharacterSummary>>> list(){
        return CustomResponseModel.wrapReadSuccess(queryHandler.getAllCharacters());
    }
}
