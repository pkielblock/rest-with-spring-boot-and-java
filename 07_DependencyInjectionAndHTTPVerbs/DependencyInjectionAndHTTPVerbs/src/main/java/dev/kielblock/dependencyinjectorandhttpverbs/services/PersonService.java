package dev.kielblock.dependencyinjectorandhttpverbs.services;

import dev.kielblock.dependencyinjectorandhttpverbs.exceptions.ResourceNotFoundException;
import dev.kielblock.dependencyinjectorandhttpverbs.model.Person;
import dev.kielblock.dependencyinjectorandhttpverbs.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records were found for this id."));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);

    }

    public Person update(Person person) {
        logger.info("Updating one person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records were found for this id."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records were found for this id."));

        repository.delete(entity);
    }
}
