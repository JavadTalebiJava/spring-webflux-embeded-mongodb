package com.exchane.market;

import com.exchane.market.model.Company;
import com.exchane.market.repo.CompanyRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ExchangeMarketApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExchangeMarketApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CompanyRepository repository) {

        Object[][] data = {
                {"company1", "http://abcd1"},
                {"company2", "http://abcd2"},
                {"company3", "http://abcd3"}
        };

        return args -> {
            repository
                    .deleteAll()
                    .thenMany(
                            Flux
                                    .just(data)
                                    .map(array -> {
                                        return new Company((String) array[0], (String) array[1]);
                                    })
                                    .flatMap(repository::save)
                    )
                    .thenMany(repository.findAll())
                    .subscribe(c -> System.out.println("saving " + c.toString()));
        };
    }

}
