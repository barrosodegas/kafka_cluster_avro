package br.com.retailsales.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.retailsales.commons.model.Invoice;

/**
 * Repository class InvoiceRepository.
 * @author Andre Barroso
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
