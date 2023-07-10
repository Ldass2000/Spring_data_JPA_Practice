package com.dass.repository;

import java.math.BigDecimal;
import java.util.List;

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
public class ProductRepositoryTest {
	
   @Autowired
   private ProductRepository productRepository;
   
//   @Test
//   void saveMethod() {
//	   
//	   //create product
//	   Product product = new Product();
//	   product.setName("product 1");
//	   product.setDescription("product 1 description");
//	   product.setSku("100BC");
//	   product.setPrice(new BigDecimal(100));
//	   product.setActive(true);
//	   product.setImageUrl("product1.png");
//	   
//	   //save product
//	   Product savedObjcet =productRepository.save(product);
//	   
//	   //display product info
//	   System.out.println(savedObjcet.getId());
//	   System.out.println(savedObjcet.toString());
//   }
//   
//   @Test
//   void updateUsingSaveMethod() {
//	    //find  or retrieve an entity by id
//	    Product product = productRepository.findById(1).get();
//	    
//	   //update entity information
//	   product.setName("updated product 1");
//	   product.setDescription("updated product 1 desc");
//	   
//	   //save updated entity'
//	   productRepository.save(product);
//   }
//   
//   @Test
//   void findByIdMethod() {
//	   Long id =1L;
//	   
//	   Product product = productRepository.findById(1).get();
//   }
   
   
   @Test
   void saveAllMethod() {
	   
	   //create product
	   Product product1 = new Product();
	   product1.setName("product 2");
	   product1.setDescription("product 2 description");
	   product1.setSku("3000BC");
	   product1.setPrice(new BigDecimal(1000));
	   product1.setActive(true);
	   product1.setImageUrl("product2.png");
	   
	   //create product
	   Product product2 = new Product();
	   product2.setName("product 3");
	   product2.setDescription("product 3 description");
	   product2.setSku("5000BC");
	   product2.setPrice(new BigDecimal(2000));
	   product2.setActive(true);
	   product2.setImageUrl("product3.png");
	   
	   productRepository.saveAll(List.of(product1,product2));
	   	   
   }
   
//   @Test
//   void findAllMethod() {
//	   List<Product> products= productRepository.findAll();
//	   
//	   products.forEach((x)->System.out.println(x));
//   }
   
//   @Test
//   void deleteByIdMethod() {
//	   productRepository.deleteById(11);
//   }
   
//   @Test
//   void  deleteMethod() {
//	   
//	   //find an entity by id
//	   Product product = productRepository.findById(12).get();
//	   
//	   //delete entity
//	   productRepository.delete(product);
//   }
   
   
//   @Test
//   void deleteAllMethod() {
//	   
//	   //productRepository.deleteAll();
//	   
//	   Product product = productRepository.findById(1).get();
//	   
//	   Product product2 = productRepository.findById(2).get();
//	   
//	   productRepository.deleteAll(List.of(product,product2));
//   }
//   
   @Test
   void countMethod() {
	   long  count= productRepository.count();
	   System.out.println(count);
   }
   
//   @Test
//   void existByIdMethod() {
//	   
//	   boolean result = productRepository.existsById(1);
//	   System.out.println(result);
//   }
   
}
