package lk.bankSystemBackend.service.impl;

import lk.bankSystemBackend.dto.BankDTO;
import lk.bankSystemBackend.entity.Bank;
import lk.bankSystemBackend.repository.BankRepository;
import lk.bankSystemBackend.service.BankService;
import lk.bankSystemBackend.service.exception.NotFoundException;
import lk.bankSystemBackend.service.util.EntityDTOTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    private final EntityDTOTransformer transformer;

    public BankServiceImpl(BankRepository bankRepository, EntityDTOTransformer transformer) {
        this.bankRepository = bankRepository;
        this.transformer = transformer;
    }

    @Override
    public BankDTO registerBank(BankDTO bank) {
        return transformer.getBankDTO(bankRepository.save(transformer.getBankEntity(bank)));
    }

    @Override
    public void updateBank(BankDTO bank) throws NotFoundException {
        Optional<Bank> optBank = bankRepository.findById(bank.getId());
        if (!optBank.isPresent()) throw new NotFoundException("invalid Bank Id");
        optBank.get().setBankName(bank.getBankName());
    }

    @Override
    public BankDTO getBankInfo(Integer bankId) throws NotFoundException {
        return bankRepository.findById(bankId).map(transformer::getBankDTO)
                .orElseThrow(() -> new NotFoundException("invalid Bank Id"));
    }

    @Override
    public void deleteBank(Integer bankId) throws NotFoundException {
        if (!bankRepository.existsById(bankId)) throw new NotFoundException("Invalid Bank Id");
        bankRepository.deleteById(bankId);
    }
}
