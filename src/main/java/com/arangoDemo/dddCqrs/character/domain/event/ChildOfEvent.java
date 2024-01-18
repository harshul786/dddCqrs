package com.arangoDemo.dddCqrs.character.domain.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ChildOfEvent {
    private String type;
    private com.arangoDemo.dddCqrs.product.domain.write_model.ChildOf childOf;
}
