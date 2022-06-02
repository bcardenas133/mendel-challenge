package com.mendel.app.service.impl;

import com.mendel.app.entity.SaveTransactionResponseDTO;
import com.mendel.app.entity.TransactionDTO;
import com.mendel.app.entity.TransactionsSumDTO;
import com.mendel.app.exception.ApiException;
import com.mendel.app.repository.TransactionRepository;
import com.mendel.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public SaveTransactionResponseDTO saveTransaction(TransactionDTO transactionDTO) {
        transactionRepository.save(transactionDTO);
        SaveTransactionResponseDTO responseDTO = new SaveTransactionResponseDTO();
        responseDTO.setStatus("ok");
        return responseDTO;
    }

    @Override
    public List<Long> getTransactionsIdByType(String transactionType) {
        List<TransactionDTO> sameTypeTransactions = transactionRepository.findByType(transactionType);
        return getTransactionIdsList(sameTypeTransactions);
    }

    @Override
    public TransactionsSumDTO getTransactionsSum(String transactionId) {
        Optional<TransactionDTO> transaction = transactionRepository.findById(transactionId);
        if (transaction.isEmpty()) {
            throw new ApiException("VALIDATION_ERROR", "There is no transaction for transactionId", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        List<TransactionDTO> transactionDTOList = transactionRepository.findByParentId(Long.valueOf(transactionId));
        transactionDTOList.add(transaction.get());
        List<TransactionDTO> listWithoutDuplicates = transactionDTOList.stream().distinct().collect(Collectors.toList());
        Double totalAmount = getAmountsSum(listWithoutDuplicates);
        TransactionsSumDTO transactionsSumDTO = new TransactionsSumDTO();
        transactionsSumDTO.setSum(totalAmount);
        return transactionsSumDTO;
    }

    private Double getAmountsSum(List<TransactionDTO> transactionDTOList) {
        List<Double> amounts = transactionDTOList.stream()
                .map(TransactionDTO::getAmount).toList();
        return amounts.stream().reduce(0.0, Double::sum);
    }

    private List<Long> getTransactionIdsList(List<TransactionDTO> sameTypeTransactions) {
        List<String> transactionIdList = sameTypeTransactions.stream()
                .map(TransactionDTO::getTransactionId).toList();

        return transactionIdList.stream()
                .map(element -> Long.valueOf(element))
                .collect(Collectors.toList());
    }
}
