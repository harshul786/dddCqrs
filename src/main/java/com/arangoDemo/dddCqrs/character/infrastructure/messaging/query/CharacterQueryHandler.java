package com.arangoDemo.dddCqrs.character.infrastructure.messaging.query;

import com.arangoDemo.dddCqrs.character.domain.event.CharacterSummaryEvent;
import com.arangoDemo.dddCqrs.character.domain.read_model.CharacterSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CharacterQueryHandler {
    private final com.arangoDemo.dddCqrs.product.infrastructure.repository.read.CharacterSummaryRepository repository;
    private final KafkaTemplate<String, CharacterSummaryEvent> kafkaTemplate;

    @KafkaListener(topics = "characters", groupId = "characters_group")
    public void processCharacterEvent(String event) {
        System.out.println("Getting event " + event);


        try{
            CharacterSummaryEvent characterSummaryEvent = null;
            characterSummaryEvent = new ObjectMapper().readValue(event, CharacterSummaryEvent.class);

            System.out.println(characterSummaryEvent);

            switch (characterSummaryEvent.getType()) {
                case "CharacterCreated", "CharacterUpdated":
                    this.repository.save(characterSummaryEvent.getCharacter());
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public List<CharacterSummary> getAllCharacters() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
