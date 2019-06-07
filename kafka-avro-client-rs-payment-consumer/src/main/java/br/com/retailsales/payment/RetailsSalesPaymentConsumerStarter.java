package br.com.retailsales.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Starter class RetailsSalesPaymentConsumerStarter
 * Class responsible for starting the application and loading the data repositories.
 * @author Andre Barroso
 */
@SpringBootApplication
@EnableJpaRepositories("br.com.retailsales.commons.repository")
public class RetailsSalesPaymentConsumerStarter {

	/**
	 * Main method - Runner.
	 * @param args Arguments - Not used in this moment.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RetailsSalesPaymentConsumerStarter.class, args);
	}
	
}
