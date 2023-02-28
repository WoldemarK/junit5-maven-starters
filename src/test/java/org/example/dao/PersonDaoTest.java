package org.example.dao;

import org.example.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonDaoTest {
    private PersonDao dao;

    @BeforeEach
    public void beforeAll() {
        this.dao = new PersonDaoImpl();
    }

    @Test
    void getPersonByPersonNameShouldReturnTrue() throws Exception {
       Person person =  dao.getPersonByPersonName("Tom");
       assertThat(person).isNotNull();
       assertThat(person.getUsername()).isEqualTo("Tom");
    }
    @Test
    void getPersonByPersonNameNullPerson()throws Exception{
        Person person = dao.getPersonByPersonName("Nik");
        assertThat(person).isNull();
    }
}