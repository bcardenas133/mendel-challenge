package com.mendel.app.service.impl;

import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;
import com.mendel.app.repository.TransactionRepository;
import com.mendel.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        return transactionRepository.save(transactionDTO);
    }

    @Override
    public List<Long> getTransactionsIdByType(String transactionType) {
        List<TransactionDTO> sameTypeTransactions = transactionRepository.findByType(transactionType);
        return getTransactionIdsList(sameTypeTransactions);
    }

    @Override
    public TransactionsSumDTO getTransactionsSum(long transactionId) {
        return null;
    }

    private List<Long> getTransactionIdsList(List<TransactionDTO> sameTypeTransactions) {
        return sameTypeTransactions.stream().map(TransactionDTO::getTransactionId).collect(Collectors.toList());
    }
}
