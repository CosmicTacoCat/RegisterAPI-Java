package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.uark.models.api.Transaction;
import edu.uark.commands.transactions.TransactionsQuery;
import edu.uark.commands.transactions.TransactionCreateCommand;

@RestController
@RequestMapping(value = "/api/transaction")

public class TransactionRestController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		return (new TransactionsQuery()).execute();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return (new TransactionCreateCommand()).
			setApiTransaction(transaction).
			execute();
	}
}