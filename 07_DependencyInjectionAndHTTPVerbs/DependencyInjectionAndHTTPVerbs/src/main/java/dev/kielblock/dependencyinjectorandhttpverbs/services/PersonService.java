package dev.kielblock.dependencyinjectorandhttpverbs.services;

import dev.kielblock.dependencyinjectorandhttpverbs.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++)  {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName("Kielblock");
        person.setAddress("Santo André");
        person.setGender("Male");
        return person;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name: " + i);
        person.setLastName("Last Name: " + i);
        person.setAddress("Address: " + i);
        person.setGender("Male");
        return person;
    }
}
