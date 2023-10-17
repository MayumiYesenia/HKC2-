package com.example.demo1.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.group.domain.Group;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);;
    }
    public Set<Person> getPersonsByPersonId(Long personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent()) {
            Group group = person.get().getGroup(); // Supongamos que la persona tiene una referencia al grupo
            if (group != null) {
                return group.getPersons();}
            }
        return null ;
        
}
}