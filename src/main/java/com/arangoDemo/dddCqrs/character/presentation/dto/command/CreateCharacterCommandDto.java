package com.arangoDemo.dddCqrs.character.presentation.dto.command;

import com.arangoDemo.dddCqrs.character.domain.write_model.Character;
import lombok.Data;

@Data
public class CreateCharacterCommandDto {
    private String name;
    private String surname;
    private boolean alive;
    private Integer age;

    public Character toCharacter() {
        Character character = new Character();
        character.setName(this.name);
        character.setSurname(this.surname);
        character.setAlive(this.alive);
        character.setAge(this.age);
        return character;
    }
}
