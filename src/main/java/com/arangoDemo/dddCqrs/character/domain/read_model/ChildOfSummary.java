package com.arangoDemo.dddCqrs.character.domain.read_model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Edge
public class ChildOfSummary {

    @Id
    private String id;

    //    @JsonIgnoreProperties("characters")
    @From
    private String childId;

    //    @JsonIgnoreProperties("characters")
    @To
    private String parentId;

    public ChildOfSummary(final String childId, final String parentId) {
        this.childId = childId;
        this.parentId = parentId;
    }

}