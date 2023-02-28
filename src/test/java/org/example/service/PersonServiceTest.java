package org.example.service;

import org.example.dao.PersonDao;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
class PersonServiceTest {
    @Mock
    private PersonDao dao;
    private PersonService service;

    public PersonServiceTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new PersonService(dao);
    }

}