package lk.bankSystemBackend.service.util;

import lk.bankSystemBackend.dto.BankDTO;
import lk.bankSystemBackend.dto.PersonDTO;
import lk.bankSystemBackend.entity.Bank;
import lk.bankSystemBackend.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOTransformer {
    private final ModelMapper mapper;

    public EntityDTOTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Bank getBankEntity(BankDTO bankDTO) {
        return mapper.map(bankDTO, Bank.class);
    }

    public Person getPersonEntity(PersonDTO personDTO) {
        return mapper.map(personDTO, Person.class);
    }

    public BankDTO getBankDTO(Bank bankEntity) {
        return mapper.map(bankEntity, BankDTO.class);
    }
    public PersonDTO getPersonDTO(Person personEntity) {
        return mapper.map(personEntity, PersonDTO.class);
    }
}
