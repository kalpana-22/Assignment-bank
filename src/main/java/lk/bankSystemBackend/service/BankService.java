package lk.bankSystemBackend.service;

import lk.bankSystemBackend.dto.BankDTO;
import lk.bankSystemBackend.service.exception.NotFoundException;


public interface BankService {
    BankDTO registerBank(BankDTO bank);

    void updateBank(BankDTO bank) throws NotFoundException;

    BankDTO getBankInfo(Integer bankId) throws NotFoundException;

    void deleteBank(Integer bankId) throws NotFoundException;
}
