package edu.uark.commands.transactions;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionDeleteCommand implements VoidCommandInterface {
	@Override
	public void execute() {
		TransactionEntity transactionEntity = this.transactionRepository.get(this.trans_id);
		if (transactionEntity == null) { //No record with the associated trans ID exists in the database.
			throw new NotFoundException("Transaction");
		}
		
		transactionEntity.delete();
	}

	//Properties
	private int trans_id;
	public int getTrans_id() {
		return this.trans_id;
	}
	public TransactionDeleteCommand setTrans_id(int trans_id) {
		this.trans_id = trans_id;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionDeleteCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionDeleteCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
