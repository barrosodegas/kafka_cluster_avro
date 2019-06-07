package br.com.retailsales.callback;

import org.springframework.stereotype.Component;

import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.commons.model.Order;

/**
 * Callback class ProducerOrderCallbackListener
 * Class accountable for running after sending data to the topic successfully or with error.
 * @author Andre Barroso
 */
@Component
public class ProducerOrderCallbackListener extends ProducerCallbackListener<String, AvroOrder, Order> {

}
