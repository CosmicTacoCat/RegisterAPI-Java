package edu.uark.commands.transactions;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

//This class is used for retreiving a single transaction. 
public class TransactionQuery implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		TransactionEntity transactionEntity = this.transactionRepository.get(this.transactionId);
		if (transactionEntity != null) {
			return new Transaction(transactionEntity);
		} else {
			throw new NotFoundException("Transaction");
		}
	}
	
	private int transactionId;
	public int getTransactionId() {
		return this.transactionId;
	}
	
	public TransactionQuery setTransactionId(int transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	
	public TransactionQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionQuery() {
		this.transactionRepository = new TransactionRepository();
	}
}

//An Object is created and transactionRepository is updated with the latest data in the constructor.
//Next we might call setTransactionId() on the object. Then with that info, we call execute
//	which will create a TransactionEntity object and give it the value of the entry in the 
//	transactionRepository that corresponds to the transactionId we just set. Finally, execute()
//	returns our transactionEntity that now contains the data we requested from the database.
