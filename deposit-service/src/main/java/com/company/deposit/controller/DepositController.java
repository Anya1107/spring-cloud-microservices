package com.company.deposit.controller;

import com.company.deposit.dto.DepositRequestDTO;
import com.company.deposit.dto.DepositResponseDTO;
import com.company.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO requestDTO){
        return depositService.deposit(requestDTO.getAccountId(), requestDTO.getBillId(), requestDTO.getAmount());
    }
}
