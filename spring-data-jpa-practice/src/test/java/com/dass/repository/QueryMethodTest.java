package com.dass.repository;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.dass.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class QueryMethodTest {
  
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void findByNameMethod() {
		
		Product product = productRepository.findByName("product 1");
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getDescription());		
	}
	
	@Test
	void findByIdMethod() {
		Product product =productRepository.findById(15L).get();
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getDescription());
	}
	
	@Test
	void findByNameOrDescriptionMethod() {
		List<Product> products = productRepository.findByNameOrDescription("product1","product 1 description");
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findByNameAndDescriptionMethod() {
		List<Product> products = productRepository.findByNameAndDescription("product 1","product 1 description");
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findDistinctByNameMethod() {
		Product product = productRepository.findDistinctByName("product1");
		
	     System.out.println(product.getId());
		 System.out.println(product.getName());
		 System.out.println(product.getDescription());
	}
	
	@Test
	void findByPriceGreaterThanMethod() {
		List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
		
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	
	@Test
	void findByPriceLessThanMethod() {
		List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
		
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findByNameContainingMethod() {
		List<Product> products = productRepository.findByNameContaining("product 1");
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	

	@Test
	void findByNameLikeMethod() {
		List<Product> products = productRepository.findByNameLike("product 1");
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findByPriceBetweenMethod() {
		List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(1500));
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findByDateCreatedBetweenMethod() {
		
		//start Date
		LocalDateTime startDate =  LocalDateTime.of(2023,07,06,00,19,57);
		
		//end Date
		LocalDateTime endDate =  LocalDateTime.of(2023,07,07,13,22,41);
		
		List<Product> products = productRepository.findByDataCreatedBetween(startDate, endDate);
		
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findByNameInMethod() {
		List<Product> products = productRepository.findByNameIn(List.of("product 1","product 2", "product 3"));
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findFirst2ByOrderByNameAscMethod() {
		List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
	
	@Test
	void findFirst3ByOrderByNameAscMethod() {
		List<Product> products = productRepository.findFirst3ByOrderByNameAsc();
		products.forEach((x)->{
			System.out.println(x.getId());
			System.out.println(x.getName());
		});
	}
}
