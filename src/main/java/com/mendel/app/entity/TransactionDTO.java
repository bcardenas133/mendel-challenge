package com.mendel.app.entity;

import com.mendel.app.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionDTO {

    private TransactionType type;
    private double amount;
    private long parentId;
}
