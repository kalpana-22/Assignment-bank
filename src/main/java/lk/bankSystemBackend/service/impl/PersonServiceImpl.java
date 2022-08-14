package lk.bankSystemBackend.service.impl;

import lk.bankSystemBackend.dto.PersonDTO;
import lk.bankSystemBackend.entity.Person;
import lk.bankSystemBackend.repository.PersonRepository;
import lk.bankSystemBackend.service.PersonService;
import lk.bankSystemBackend.service.exception.NotFoundException;
import lk.bankSystemBackend.service.util.EntityDTOTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final EntityDTOTransformer transformer;

    public PersonServiceImpl(PersonRepository personRepository, EntityDTOTransformer transformer) {
        this.personRepository = personRepository;
        this.transformer = transformer;
    }

    @Override
    public PersonDTO registerPerson(PersonDTO person) {
        return transformer.getPersonDTO(personRepository.save(transformer.getPersonEntity(person)));
    }

    @Override
    public void updatePerson(PersonDTO person) throws NotFoundException {
        Optional<Person> optPerson = personRepository.findById(person.getId());
        if (!optPerson.isPresent()) throw new NotFoundException("invalid Person Id");
        optPerson.get().setFirstName(person.getFirstName());
        optPerson.get().setLastName(person.getLastName());
        optPerson.get().setLastName(person.getLastName());
        optPerson.get().setAddress(person.getAddress());
        optPerson.get().setDob(person.getDob());
        optPerson.get().setGender(person.getGender());
        optPerson.get().setNic(person.getNic());
        optPerson.get().setPhoneNumber(person.getPhoneNumber());
    }

    @Override
    public PersonDTO getPersonInfo(Integer personId) throws NotFoundException {
        return personRepository.findById(personId).map(transformer::getPersonDTO)
                .orElseThrow(() -> new NotFoundException("invalid Bank Id"));
    }

    @Override
    public void deletePerson(Integer personId) throws NotFoundException {
        if (!personRepository.existsById(personId)) throw new NotFoundException("Invalid Bank Id");
        personRepository.deleteById(personId);
    }
}
