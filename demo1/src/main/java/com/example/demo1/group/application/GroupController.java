package com.example.demo1.group.application;
import com.example.demo1.group.domain.Group;
import com.example.demo1.group.domain.GroupService;
import com.example.demo1.person.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroup() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Group>> group(@PathVariable Long id) {
        Optional<Group> group = groupService.findById(id);
        return ResponseEntity.status(200).body(group);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<List<Person>> groupPersons(@PathVariable Long id) {
        Set<Person> persons = groupService.getGroupPersonsById(id);
        if (persons != null && !persons.isEmpty()) {
            List<Person> personList = new ArrayList<>(persons);
            return ResponseEntity.status(200).body(personList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}