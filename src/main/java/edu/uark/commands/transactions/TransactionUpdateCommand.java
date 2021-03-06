package edu.uark.commands.transactions;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionUpdateCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		//Validations
		if (this.apiTransaction.getTrans_Id() == -1) {
			throw new UnprocessableEntityException("trans_id");
		}

		TransactionEntity transactionEntity = this.transactionRepository.get(this.trans_id);
		if (transactionEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Transaction");
		}
		
		this.apiTransaction = transactionEntity.synchronize(this.apiTransaction); //Synchronize any incoming changes for UPDATE to the database.
		
		transactionEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiTransaction;
	}

	//Properties
	private int trans_id;
	public int getTrans_id() {
		return this.trans_id;
	}
	public TransactionUpdateCommand setTransactionId(int trans_id) {
		this.trans_id = trans_id;
		return this;
	}
	
	private Transaction apiTransaction;
	public Transaction getApiTransaction() {
		return this.apiTransaction;
	}
	public TransactionUpdateCommand setApiTransaction(Transaction apiTransaction) {
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionUpdateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionUpdateCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}