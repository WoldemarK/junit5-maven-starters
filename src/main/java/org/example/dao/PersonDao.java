package org.example.dao;

import org.example.model.Person;

public interface PersonDao {
    Person getPersonByPersonName(String personName) throws Exception;
}
