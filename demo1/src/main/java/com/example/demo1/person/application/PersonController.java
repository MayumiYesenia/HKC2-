package com.example.demo1.person.application;
import com.example.demo1.group.domain.Group;
import com.example.demo1.person.domain.Person;
import com.example.demo1.person.domain.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> person(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<List<Group>> group(@PathVariable Long id) {
        Set<Person> persons = personService.getPersonsByPersonId(id);
        List<Group> personGroups = new ArrayList<>();

        if (persons != null) {
            for (Person person : persons) {
                Group group = person.getGroup();
                if (group != null) {
                    personGroups.add(group);
                }
            }
        }

        if (!personGroups.isEmpty()) {
            return ResponseEntity.status(200).body(personGroups);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
