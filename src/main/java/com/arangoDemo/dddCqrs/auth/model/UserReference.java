package com.arangoDemo.dddCqrs.auth.model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Edge
public class UserReference {
    @Id // db document field: _key
    private String id;

    @ArangoId // db document field: _id
    private String arangoId;

    @From
    private UserInfo user;

    @To
    private UserRole role;
}
