package com.arangoDemo.dddCqrs.auth.model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Builder
@Document("PERMISSIONS")
public class UserPermission {
    @Id // db document field: _key
    private String id;
    @ArangoId // db document field: _id
    private String arangoId;
    @JsonIgnore
    private Set<String> validNames = Set.of("CREATE", "READ", "UPDATE", "DELETE");
    private String name;
    public void setName(String name) {
        if (!validNames.contains(name.toUpperCase())) {
            throw new IllegalArgumentException("Invalid permission name. Valid names are: CREATE, READ, UPDATE, DELETE");
        }
        this.name = name.toUpperCase();
    }

    public boolean validateNames(){
        if (!validNames.contains(name.toUpperCase())) {
            throw new IllegalArgumentException("Invalid permission name. Valid names are: CREATE, READ, UPDATE, DELETE");
        } else {
            return true;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArangoId() {
        return arangoId;
    }

    public void setArangoId(String arangoId) {
        this.arangoId = arangoId;
    }

    public Set<String> getValidNames() {
        return validNames;
    }

    public void setValidNames(Set<String> validNames) {
        this.validNames = validNames;
    }

    public String getName() {
        return name;
    }
}
