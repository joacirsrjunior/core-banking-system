package br.com.bank.core.repository;

import br.com.bank.core.entity.Account;
import br.com.bank.core.entity.Transaction;
import br.com.bank.core.services.implementation.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TransactionRepository {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<Transaction> insert(Transaction transaction) {
        return reactiveMongoTemplate.insert(transaction);
    }

    public Mono<Transaction> save(Transaction transaction) {
        logger.debug("Saving transaction into database...");
        return reactiveMongoTemplate.save(transaction);
    }

}