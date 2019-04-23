package edu.uark.models.repositories.interfaces;

import java.util.UUID;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.ProdInTransEntity;

public interface ProdInTransRepositoryInterface extends BaseRepositoryInterface<ProdInTransEntity> {
	ProdInTransEntity byTransaction_Id(int transaction_Id);
}