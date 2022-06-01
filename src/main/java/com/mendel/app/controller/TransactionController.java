package com.mendel.app.controller;

import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;
import com.mendel.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("{transactionId}")
    public ResponseEntity<TransactionDTO> saveTransaction(@Valid @PathVariable String transactionId, @Valid @RequestBody TransactionDTO transactionDTO) {
        transactionDTO.setTransactionId(transactionId);
        TransactionDTO transaction = transactionService.saveTransaction(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/types/{type}")
    public List<Long> getByType(@Valid @PathVariable String type) {
        return transactionService.getTransactionsIdByType(type);
    }

    @GetMapping("/sum/{transactionId}")
    public ResponseEntity<TransactionsSumDTO> getSum(@Valid @PathVariable String transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionsSum(transactionId), HttpStatus.CREATED);
    }
}
