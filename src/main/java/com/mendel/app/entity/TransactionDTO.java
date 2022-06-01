package com.mendel.app.entity;

import com.mendel.app.enums.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transaction")
public class TransactionDTO {

    @Id
    private long transactionId;
    private TransactionType type;
    private double amount;
    private long parentId;
}
