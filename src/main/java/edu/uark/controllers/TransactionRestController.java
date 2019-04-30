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
import edu.uark.models.api.Cart;
import edu.uark.commands.transactions.TransactionQuery;
import edu.uark.commands.transactions.TransactionsQuery;
import edu.uark.commands.transactions.TransactionCreateCommand;
import java.util.ArrayList;;

@RestController
@RequestMapping(value = "/api/transaction")

public class TransactionRestController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		return (new TransactionsQuery()).execute();
	}
	
	//Perhaps Requesting a single transaction should retrieve the products involved as well.
	@RequestMapping(value = "/{transaction_id}", method = RequestMethod.GET)
	public Transaction getTransaction(@PathVariable int transactionId) {
		return (new TransactionQuery()).
			setTransactionId(transactionId).
			execute();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody ArrayList<Transaction> transaction) {
		return (new TransactionCreateCommand()).
			setApiTransaction(transaction).
			execute();
	}
	
	/*@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Cart cart) {
		return (new TransactionCreateCommand()).
			setApiCart(cart).
			execute();
	}*/
	
}
