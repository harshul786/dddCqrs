package com.arangoDemo.dddCqrs.auth.model;


import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("ROLES")
public class UserRole {
    @Id // db document field: _key
    private String id;
    @ArangoId // db document field: _id
    private String arangoId;

    private String name;

    @Relations(edges = RolePermissionReference.class, lazy = true)
    private Collection<UserPermission> permissions = new HashSet<>();


    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", arangoId='" + arangoId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public UserRole(String Name){
        this.name=Name;
        this.setPermissions(new HashSet<>());
    }
}
