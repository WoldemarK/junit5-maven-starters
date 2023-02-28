package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.PersonDao;
import org.example.model.Person;

@RequiredArgsConstructor
public class PersonService {
    private final PersonDao personDao;

    public boolean checkPersonPresence(Person person) throws Exception {
        Person per = personDao.getPersonByPersonName(person.getUsername());
        return per != null;
    }
}
