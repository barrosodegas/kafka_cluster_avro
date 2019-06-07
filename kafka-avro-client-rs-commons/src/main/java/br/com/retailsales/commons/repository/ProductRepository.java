package br.com.retailsales.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.retailsales.commons.model.Product;

/**
 * Repository class ProductRepository.
 * @author Andre Barroso
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	/**
	 * Method responsible to find product by code.
	 * @param productCode Product Code.
	 * @return Product.
	 */
	@Query("SELECT p FROM product p WHERE p.code=:productCode")
	Product findByCode(@Param("productCode") String productCode);

}
