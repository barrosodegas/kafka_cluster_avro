package br.com.retailsales.commons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.retailsales.commons.model.Order;

/**
 * Repository class OrderRepository.
 * @author Andre Barroso
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	/**
	 * Method responsible to find order by code.
	 * @param orderCode Order Code.
	 * @return Order.
	 */
	@Query("SELECT o FROM order_sales o WHERE o.code=:orderCode")
	Order findByCode(@Param("orderCode") String orderCode);

}
