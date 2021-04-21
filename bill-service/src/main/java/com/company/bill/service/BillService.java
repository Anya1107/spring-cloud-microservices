package com.company.bill.service;

import com.company.bill.entity.Bill;
import com.company.bill.exception.BillNotFoundException;
import com.company.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long billId){
        return billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException("Unable to find bill with id: " + billId));
    }

    public Long createBill(Long accountId, BigDecimal amount,
                           Boolean isDefault, OffsetDateTime creationDate, Boolean overdraftEnabled){
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount,
                           Boolean isDefault, Boolean overdraftEnabled){
        Bill bill = new Bill(billId, accountId, amount, isDefault, overdraftEnabled);
         return billRepository.save(bill);
    }

    public Bill deleteBill(Long billId){
        Bill deletedBill = getBillById(billId);
        billRepository.deleteById(billId);
        return deletedBill;
    }
}