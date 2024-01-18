package com.arangoDemo.dddCqrs.product.domain.write_model;

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
public class ChildOf {

    @Id
    private String id;

    //    @JsonIgnoreProperties("characters")
    @From
    private String childId;

    //    @JsonIgnoreProperties("characters")
    @To
    private String parentId;

    public ChildOf(final String childId, final String parentId) {
        this.childId = childId;
        this.parentId = parentId;
    }

}