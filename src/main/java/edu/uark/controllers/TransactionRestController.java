package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

    //import edu.uark.commands.products.ProductByLookupCodeQuery;
    //import edu.uark.commands.products.ProductCreateCommand;
    //import edu.uark.commands.products.ProductDeleteCommand;
    //import edu.uark.commands.products.ProductQuery;
    //import edu.uark.commands.products.ProductUpdateCommand;
    //import edu.uark.commands.products.ProductsQuery;
import edu.uark.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")

public class TransactionRestController
{
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getTransactions() {
		return (new TransactionsQuery()).execute();
	}*/
}