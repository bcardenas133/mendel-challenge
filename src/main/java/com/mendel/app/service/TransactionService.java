package com.mendel.app.service;

import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;

import java.util.List;

public interface TransactionService {

    TransactionDTO saveTransaction(TransactionDTO transactionDTO);

    List<Double> getTransactionsIdByType(String transactionType);

    TransactionsSumDTO getTransactionsSum(long transactionId);
}
