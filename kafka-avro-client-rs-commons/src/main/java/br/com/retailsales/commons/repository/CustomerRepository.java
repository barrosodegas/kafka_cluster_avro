package br.com.retailsales.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.retailsales.commons.model.Customer;

/**
 * Repository class CustomerRepository.
 * @author Andre Barroso
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * Method responsible to find customer by code.
	 * @param customerCode Customer Code.
	 * @return Customer.
	 */
	@Query("SELECT c FROM customer c WHERE c.code=:customerCode")
	Customer findByCode(@Param("customerCode") String customerCode);

}
