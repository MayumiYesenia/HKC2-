package com.example.demo1.person.domain;
import jakarta.persistence.*;
import java.util.Set;
import javax.swing.GroupLayout.Group;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Set<Group> groups;

    public Person() {}

    public Person(Long id, String name, Set<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }


    // Getters y setters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    // toString

    @Override
    public String toString() {
        return "Person{" + "id=" + this.id + ", name='" + this.name + '\'' + ", groups='" + this.groups + '\'' + '}';
    }

    // equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return this.id.equals(person.id);
    }

	public String getGroup() {
		return null;
	}

}