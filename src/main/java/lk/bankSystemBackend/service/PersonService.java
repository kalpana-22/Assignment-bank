package lk.bankSystemBackend.service;

import lk.bankSystemBackend.dto.PersonDTO;
import lk.bankSystemBackend.service.exception.NotFoundException;

public interface PersonService {
    PersonDTO registerPerson(PersonDTO person);

    void updatePerson(PersonDTO person) throws NotFoundException;

    PersonDTO getPersonInfo(Integer personId) throws NotFoundException;

    void deletePerson(Integer personId) throws NotFoundException;
}
