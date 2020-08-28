package com.kata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.model.Transaction;
import com.kata.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
		
	
	 // Find
    @GetMapping
    List<Transaction> findAll() {
        return transactionService.findAll();
    }
    
    // Find
    @GetMapping("/{accountId}")
	public List<Transaction> findTransByAccount(@PathVariable long accountId) {
		return transactionService.findTransByAccount(accountId);
	}

}
