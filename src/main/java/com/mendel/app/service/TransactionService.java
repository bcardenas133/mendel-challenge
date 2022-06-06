package com.mendel.app.service;

import com.mendel.app.entity.SaveTransactionResponseDTO;
import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;

import java.util.List;

public interface TransactionService {

    /**
     * Save transaction in database
     * @param transactionDTO information to save
     * @return transaction result
     */
    SaveTransactionResponseDTO saveTransaction(TransactionDTO transactionDTO);

    /**
     * Get list of transactionsId related with transaction type
     * @param transactionType type of transaction to look for
     * @return list of transactionsId associated to the transaction type
     */
    List<Long> getTransactionsIdByType(String transactionType);

    /**
     * Get sum of amounts related with transactionId and connected parentIds
     * @param transactionId transactionId to look in db
     * @return total amount 
     */
    TransactionsSumDTO getTransactionsSum(String transactionId);
}
