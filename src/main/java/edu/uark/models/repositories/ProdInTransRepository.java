package edu.uark.models.repositories;

import java.sql.SQLException;

import java.util.UUID;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class ProdInTransRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
	@Override
	public TransactionEntity byTransaction_Id(UUID transaction_id) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.TRANS_ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, transaction_id);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}

	@Override
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	//BaseRepository's get method parameter is UUID whereas our transaction ids are integers.
	public TransactionEntity get(UUID id) {
		return firstOrDefaultWhere(
			null,
			(new WhereContainer(
				(new WhereClause()).
					table(primaryTable).
					fieldName(TransactionFieldNames.TRANS_ID).
					comparison(SQLComparisonType.EQUALS)
			)),
			null,
			(ps) -> {
				try {
					ps.setObject(1, id);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}

	public ProdInTransRepository() {
		super(DatabaseTable.PRODUCT_IN_TRANSACTION);
	}
}