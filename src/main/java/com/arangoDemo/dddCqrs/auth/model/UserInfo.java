package com.arangoDemo.dddCqrs.auth.model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("USERS")
public class UserInfo {
    @Id // db document field: _key
    private String id;
    @ArangoId // db document field: _id
    private String arangoId;

    private String username;

    private String password;

    private String email;

    @Relations(edges = UserReference.class, lazy = true)
    private Collection<UserRole> roles;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", arangoId='" + arangoId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
