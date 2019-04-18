package edu.uark.commands.transactions;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionCreateCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		//Validations
		/*if (StringUtils.isBlank(this.apiProduct.getLookupCode())) {
			throw new UnprocessableEntityException("lookupcode");
		}*/

		TransactionEntity transactionEntity = this.transactionRepository.byTransaction_Id(this.apiTransaction.getTrans_Id());
		if (transactionEntity != null) {
			throw new ConflictException("trans_id"); //Transaction ID already defined for another Transaction.
		}
		
		//No ENTITY object was returned from the database, thus the API object's Transaction id must be unique.
		transactionEntity = new TransactionEntity(apiTransaction); //Create a new ENTITY object from the API object details.
		transactionEntity.save(); //Write, via an INSERT, the new record to the database.
		
		//this.apiProduct.setId(productEntity.getId()); //Synchronize information generated by the database upon INSERT.
		//this.apiProduct.setCreatedOn(productEntity.getCreatedOn());

		return this.apiTransaction;
	}

	//Properties
	private Transaction apiTransaction;
	public Transaction getApiTransaction() {
		return this.apiTransaction;
	}
	public TransactionCreateCommand setApiTransaction(Transaction apiTransaction) {
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionCreateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionCreateCommand() {
		this.transactionRepository = new TransactionRepository();
	} 
}