package lk.bankSystemBackend.api;

import lk.bankSystemBackend.dto.BankDTO;
import lk.bankSystemBackend.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("api/banks")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public BankDTO registerBank(@RequestBody @Valid BankDTO bank, Errors errors) {
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }
        return bankService.registerBank(bank);
    }

    @GetMapping(value = "/{bankId:[0-9]+}", produces = "application/json")
    public BankDTO getBankInfo(@PathVariable Integer bankId) {
        return bankService.getBankInfo(bankId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{bankId:[0-9]+}")
    public void deleteBank(@PathVariable Integer bankId) {
        bankService.deleteBank(bankId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{bankId:[0-9]+}", consumes = "application/json")
    public void updateBank(@PathVariable Integer bankId, @RequestBody @Valid BankDTO bank, Errors errors) {
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }
        bank.setId(bankId);
        bankService.updateBank(bank);
    }
}
