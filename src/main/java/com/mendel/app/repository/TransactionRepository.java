package com.mendel.app.repository;

import com.mendel.app.entity.TransactionDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionDTO, String> {
}
