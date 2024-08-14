package dev.kielblock.dependencyinjectorandhttpverbs.repositories;

import dev.kielblock.dependencyinjectorandhttpverbs.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
