package edu.uark.dataaccess.repository;

public enum DatabaseTable {
	NONE(""),
	EMPLOYEE("employee"),
	PRODUCT("product"),
	TRANSACTION("transaction"),
	PRODUCT_IN_TRANSACTION("product_in_transaction");


	public String getLabel() {
		return label;
	}
	
	private final String label;
	
	private DatabaseTable(String label) {
		this.label = label;
	}
}
