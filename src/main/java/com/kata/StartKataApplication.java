package com.kata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.kata.model.Account;
import com.kata.model.Customer;
import com.kata.repo.AccountRepository;
import com.kata.repo.CustomerRepository;


@SpringBootApplication
@EnableCaching
public class StartKataApplication {
	// start everything
    public static void main(String[] args) {
        SpringApplication.run(StartKataApplication.class, args);
    }
    
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository, CustomerRepository custRepo) {
        return args -> {
        	Customer customer1= new Customer("ying");
        	custRepo.save(customer1); 
        	Customer customer2= new Customer("jenny");
        	custRepo.save(customer2);
        	
        	Account a1 = new Account(customer1);
        	accountRepository.save(a1);	
        	Account a2 = new Account(customer1);
        	accountRepository.save(a2);	 	
        };
    }

}
