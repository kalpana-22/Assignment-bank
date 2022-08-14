package lk.bankSystemBackend.repository;

import lk.bankSystemBackend.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Integer> {
}
