package com.company.deposit.repository;

import com.company.deposit.entity.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
}
