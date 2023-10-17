package com.example.demo1.group.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.person.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public void deleteById(Long id){
        groupRepository.deleteById(id);;
    }

    public Set<Person> getGroupPersonsById(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            return group.get().getPersons();
        }
        return null;
    }
}