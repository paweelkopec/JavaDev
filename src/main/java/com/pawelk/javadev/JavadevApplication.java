package com.pawelk.javadev;

import com.pawelk.javadev.models.Activity;
import com.pawelk.javadev.models.User;
import com.pawelk.javadev.repositories.ActivityRepository;
import com.pawelk.javadev.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavadevApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavadevApplication.class, args);
	}


	private static final Logger log = LoggerFactory.getLogger(JavadevApplication.class);

//	@Bean
//	public CommandLineRunner demo(ActivityRepository repository) {
//			return (args) -> {
//				log.info("Activity found with findAll():");
//			log.info("-------------------------------");
//			for (Activity activity : repository.findAll()) {
//				log.info(activity.toString());
//			}
//			log.info("");
//			};
//	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1L)
//					.ifPresent(customer -> {
//						log.info("Customer found with findById(1L):");
//						log.info("--------------------------------");
//						log.info(customer.toString());
//						log.info("");
//					});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}
}
