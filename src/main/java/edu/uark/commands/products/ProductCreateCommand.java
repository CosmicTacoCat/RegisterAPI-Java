package edu.uark.commands.products;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Product;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductCreateCommand implements ResultCommandInterface<Product> {
	@Override
	public Product execute() {
		//Validations
		/*if (StringUtils.isBlank(this.apiProduct.getLookupCode())) {
			throw new UnprocessableEntityException("lookupcode");
		}*/

		ProductEntity productEntity = this.productRepository.byLookupCode(this.apiProduct.getLookupCode());
		if (productEntity != null) {
			throw new ConflictException("lookupcode"); //Lookupcode already defined for another product.
		}
		
		//No ENTITY object was returned from the database, thus the API object's lookupcode must be unique.
		productEntity = new ProductEntity(apiProduct); //Create a new ENTITY object from the API object details.
		productEntity.save(); //Write, via an INSERT, the new record to the database.
		
		this.apiProduct.setId(productEntity.getId()); //Synchronize information generated by the database upon INSERT.
		this.apiProduct.setCreatedOn(productEntity.getCreatedOn());

		return this.apiProduct;
	}

	//Properties
	private Product apiProduct;
	public Product getApiProduct() {
		return this.apiProduct;
	}
	public ProductCreateCommand setApiProduct(Product apiProduct) {
		this.apiProduct = apiProduct;
		return this;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductCreateCommand setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductCreateCommand() {
		this.productRepository = new ProductRepository();
	} 
}
