package br.com.retailsales.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.retailsales.commons.model.Payment;

/**
 * Repository class PaymentRepository.
 * @author Andre Barroso
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	/**
	 * Method responsible to find payment by code.
	 * @param paymentCode Payment Code.
	 * @return Payment
	 */
	@Query("SELECT p FROM payment p WHERE p.code=:paymentCode")
	Payment findByCode(@Param("paymentCode") String paymentCode);

}
