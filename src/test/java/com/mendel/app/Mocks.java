package com.mendel.app;

import com.mendel.app.entity.TransactionDTO;

import java.util.Arrays;
import java.util.List;

public class Mocks {

    public static TransactionDTO getSaveTransactionBody() {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(100);
        transactionDTO.setType("cars");
        transactionDTO.setParentId(10l);

        return transactionDTO;
    }

    public static List<TransactionDTO> getTransactionsMocks() {
        TransactionDTO transaction = getSaveTransactionBody();
        transaction.setTransactionId("15");
        TransactionDTO anotherTransaction = getSaveTransactionBody();
        anotherTransaction.setTransactionId("16");

        return Arrays.asList(transaction, anotherTransaction);
    }

    public static List<TransactionDTO> getMockForGetSumEndpointTesting() {
        TransactionDTO firstTransaction = getSaveTransactionBody();
        firstTransaction.setTransactionId("10");

        TransactionDTO secondTransaction = getSaveTransactionBody();
        secondTransaction.setTransactionId("11");

        TransactionDTO thirdTransaction = getSaveTransactionBody();
        thirdTransaction.setTransactionId("12");

        return Arrays.asList(firstTransaction, secondTransaction, thirdTransaction);
    }
}
