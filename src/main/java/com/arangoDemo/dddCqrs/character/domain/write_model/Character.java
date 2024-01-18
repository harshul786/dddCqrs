package com.arangoDemo.dddCqrs.character.domain.write_model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.PersistentIndex;
import com.arangodb.springframework.annotation.Relations;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Document
@PersistentIndex(fields = {"surname"})
public class Character {

    @Id // db document field: _key
    private String id;
    private String name;
    private String surname;
    private boolean alive;
    private Integer age;

    @Relations(edges = com.arangoDemo.dddCqrs.product.domain.write_model.ChildOf.class, lazy = true, maxDepth = 1, direction= Relations.Direction.INBOUND)
    private Collection<Character> childs;

    public Character() {
        super();
    }


    public Character(final String name, final String surname, final boolean alive) {
        super();
        this.name = name;
        this.surname = surname;
        this.alive = alive;
    }

    public Character(final String name, final String surname, final boolean alive, final Integer age) {
        super();
        this.name = name;
        this.surname = surname;
        this.alive = alive;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

//    @JsonManagedReference
    public Collection<Character> getChilds() {
        return childs;
    }

    public void setChilds(final Collection<Character> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "CharacterSummary{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", alive=" + alive +
                ", age=" + age +
                ", childs=" + childs +
                '}';
    }
}
