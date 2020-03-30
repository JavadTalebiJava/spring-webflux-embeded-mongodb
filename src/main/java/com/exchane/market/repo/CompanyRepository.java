package com.exchane.market.repo;


import com.exchane.market.model.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

    Mono<Company> findFirstByName(Mono<String> name);
}
