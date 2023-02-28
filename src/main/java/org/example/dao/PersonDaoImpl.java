package org.example.dao;

import org.example.model.Person;

import java.util.Arrays;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private final List<Person> people;

    public PersonDaoImpl() {
        this.people = Arrays.asList(
                new Person("Tom", "GUEST"),
                new Person("Bob", "USER"));
                new Person("Nik", "ADMIN");
    }

    @Override
    public Person getPersonByPersonName(String personname) throws Exception {
        return people.stream()
                .filter(person -> person.getUsername().equals(personname))
                .findAny()
                .orElse(null);
    }
}
