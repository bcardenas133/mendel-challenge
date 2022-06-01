package com.mendel.app.service.impl;

import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;
import com.mendel.app.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {

        return transactionDTO;
    }

    @Override
    public List<Double> getTransactionsIdByType(String transactionType) {
        return null;
    }

    @Override
    public TransactionsSumDTO getTransactionsSum(long transactionId) {
        return null;
    }
}
