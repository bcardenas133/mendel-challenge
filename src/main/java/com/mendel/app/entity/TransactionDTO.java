package com.mendel.app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transaction")
public class TransactionDTO {

    @Id
    private String transactionId;
    private String type;
    private double amount;
    private long parentId;
}
