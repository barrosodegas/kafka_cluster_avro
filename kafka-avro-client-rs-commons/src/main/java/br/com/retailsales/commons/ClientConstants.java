package br.com.retailsales.commons;

/**
 * Class with the access constants to Avro Schema.
 * @author Andre Barroso
 *
 */
public final class ClientConstants {

	/**
	 * Broker address list separated by ",".
	 */
	public static final String KAFKA_BROKERS = "kafka1:9092,kafka2:9092,kafka3:9092";
	
	/**
	 * Ack that does not expect response from the broker to post data.
	 */
	public static final String ACK_NO = "0";
	
	/**
	 * Ack that expect response from the broker leader to post data.
	 */
	public static final String ACK_ONLY_THE_LEADER = "1";
	
	/**
	 * Ack that expect response from the all brokers to post data.
	 */
	public static final String ACK_ALL = "all";
	
	/**
	 * Client ID producer.
	 */
	public static final String CLIENT_ID_PRODUCER = "producer";
	
	/**
	 * Client ID consumer.
	 */
	public static final String CLIENT_ID_CONSUMER = "consumer";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES = "retail-sales";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_ORDER = "rs-order";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_PAYMENT = "rs-payment";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_INVOICE = "rs-invoice";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_STOVK_SEPARATION = "rs-stock-separation";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_RELEASED_FOR_DELIVERY = "rs-released-for-delivery";
	
	/**
	 * Topic name.
	 */
	public static final String TOPIC_NAME_SALES_DELIVERY_CONFIRMATION = "rs-delivery-confirmation";

	/**
	 * Consumer group ID.
	 */
	public static final String GROUP_ID_CONSUMERS = "consumerGroup";

	/**
	 * Consumer group ID to topic order.
	 */
	public static final String GROUP_ID_CONSUMERS_ORDER = "consumerGroup-order";
	
	/**
	 * Max number of records not found.
	 */
	public static final int MAX_NO_RECORDS_FOUND= 100;
	
	/**
	 * Max message count.
	 */
	public static final int MESSAGE_COUNT= 100;

	/**
	 * Offset reset type latest.
	 */
	public static final String OFFSET_RESET_LATEST = "latest";

	/**
	 * Offset reset type earliest.
	 */
	public static final String OFFSET_RESET_EARLIEST = "earliest";

	/**
	 * Max record by poll on topic partition.
	 */
	public static final int MAX_POLL_RECORD = 1;

	/**
	 * Avro schema registry host.
	 */
	public static final String SCHEMA_REGISTRY_URL = "http://avroschema:8081";

	/**
	 * Disable or enable auto commit.
	 */
	public static final String ENABLE_AUTO_COMMIT = "false";

	/**
	 * Definar specific Avro reader schema.
	 */
	public static final boolean SPECIFIC_AVRO_READER = true;
	
}
