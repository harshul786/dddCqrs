package com.arangoDemo.dddCqrs.character.domain.event;

import com.arangoDemo.dddCqrs.character.domain.read_model.ChildOfSummary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ChildOfSummaryEvent {
    private String type;
    private ChildOfSummary childOfSummary;
}
