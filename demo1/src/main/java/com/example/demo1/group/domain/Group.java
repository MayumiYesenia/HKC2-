package com.example.demo1.group.domain;

import jakarta.persistence.*;

import java.util.Set;

import com.example.demo1.person.domain.Person;
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    
    @ManyToMany
    @JoinColumn(name = "group_id")
    private Set<Person> persons;

    public Group() {}

    public Group(Long id, String name, Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons =persons;
    }


    // Getters y setters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Person> getPersons() {
        return this.persons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    // toString

    @Override
    public String toString() {
        return "Group{" + "id=" + this.id + ", name='" + this.name + '\'' + ", persons='" + this.persons+ '\'' + '}';
    }

    // equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Group))
            return false;
        Group group = (Group) o;
        return this.id.equals(group.id);
    }

}
