package lk.bankSystemBackend.api;

import lk.bankSystemBackend.dto.BankDTO;
import lk.bankSystemBackend.dto.PersonDTO;
import lk.bankSystemBackend.service.BankService;
import lk.bankSystemBackend.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public PersonDTO registerPerson(@RequestBody @Valid PersonDTO person, Errors errors) {
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }
        return personService.registerPerson(person);
    }

    @GetMapping(value = "/{personId:[0-9]+}", produces = "application/json")
    public PersonDTO getPersonInfo(@PathVariable Integer personId) {
        return personService.getPersonInfo(personId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{personId:[0-9]+}")
    public void deletePerson(@PathVariable Integer personId) {
        personService.deletePerson(personId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{personId:[0-9]+}", consumes = "application/json")
    public void updatePerson(@PathVariable Integer personId, @RequestBody @Valid PersonDTO person, Errors errors) {
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }
        person.setId(personId);
        personService.updatePerson(person);
    }
}
