package com.arangoDemo.dddCqrs.character.domain.event;

import com.arangoDemo.dddCqrs.character.domain.write_model.Character;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class CharacterEvent {
    private String type;
    private Character character;

    public CharacterEvent(String type, Character character) {
        this.type = type;
        this.character = character;
    }
    @Override
    public String toString() {
        return "CharacterEvent [type=" + type + ", character=" + character + "]";
    }
}
