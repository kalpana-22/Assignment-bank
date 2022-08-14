package lk.bankSystemBackend.repository;

import lk.bankSystemBackend.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
