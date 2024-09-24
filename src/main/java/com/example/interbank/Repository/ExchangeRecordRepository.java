package com.example.interbank.Repository;

import com.example.interbank.model.ExchangeRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExchangeRecordRepository extends ReactiveMongoRepository<ExchangeRecord, Long> {}