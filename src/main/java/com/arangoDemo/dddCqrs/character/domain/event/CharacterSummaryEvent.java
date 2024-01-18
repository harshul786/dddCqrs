package com.arangoDemo.dddCqrs.character.domain.event;

import com.arangoDemo.dddCqrs.character.domain.read_model.CharacterSummary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterSummaryEvent {
    private String type;
    private CharacterSummary character;

    public CharacterSummaryEvent(String type, CharacterSummary character) {
        this.type = type;
        this.character = character;
    }

    @Override
    public String toString() {
        return "CharacterEvent [type=" + type + ", character=" + character + "]";
    }
}
