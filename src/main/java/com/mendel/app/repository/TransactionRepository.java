package com.mendel.app.repository;

import com.mendel.app.entity.TransactionDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<TransactionDTO, String> {

    List<TransactionDTO> findByType(String type);
    List<TransactionDTO> findByParentId(long parentId);
}
