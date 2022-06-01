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

    @PutMapping
    public ResponseEntity<TransactionDTO> saveTransaction(@Valid @RequestParam Double transactionId, @Valid @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO transaction = transactionService.saveTransaction(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/types")
    public List<Double> getByType(@Valid @RequestParam String transactionType) {
        return transactionService.getTransactionsIdByType(transactionType);
    }

    @GetMapping("/sum")
    public ResponseEntity<TransactionsSumDTO> getSum(@Valid @RequestParam long transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionsSum(transactionId), HttpStatus.CREATED);
    }
}
