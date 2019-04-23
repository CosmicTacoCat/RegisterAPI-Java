package edu.uark.models.repositories.interfaces;

import java.util.UUID;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.TransactionEntity;

public interface TransactionRepositoryInterface extends BaseRepositoryInterface<TransactionEntity> {
	TransactionEntity byTransaction_Id(int transaction_Id);
}