package com.iyihua.bootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.commerce.soa.search.SoaSearchBoot;
import com.iyihua.commerce.soa.search.model.Customer;
import com.iyihua.commerce.soa.search.repository.CustomerRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SoaSearchBoot.class)
public class AppTest extends TestCase {

	@Autowired CustomerRepository repository;
	
	@Test
	public void TestEs() {
//		saveCustomers();
		fetchAllCustomers();
//		fetchAll();
	}
	
	private void saveCustomers() {
//		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Yihua", "Wanglv"));
	}

	private void fetchAllCustomers() {
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer.toString());
		}
		System.out.println();
	}

	private void fetchIndividualCustomers() {
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
	
}
