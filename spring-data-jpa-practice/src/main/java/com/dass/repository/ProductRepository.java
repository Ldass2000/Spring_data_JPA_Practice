package com.dass.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dass.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
  
	/*
	 * Returns the found product entry by using it's name as search
	 * criteria. If no product entry is found , this method return null;
	 */
	public Product findByName(String name);
	
	
	/*
	 * Returns an Optional which contains the  found product entry
	 * by using its id as  search criteria. If no product entry
	 * is found, this method returns an empty Optional
	 */
	Optional<Product> findById(long id);
	
	
	/*
	 * Returns the found list of product entries whose name or description is
	 * given as a method parameters. if no product entries is found, this method
	 * returns an empty list.
	 */
	List<Product> findByNameOrDescription(String name, String description);
	
	
	/*
	 * Returns the found list of product entries whose and  description is
	 * given as a method parameters. if no product entries is found, this method
	 * returns an empty list.
	 */
	List<Product> findByNameAndDescription(String name, String description);
	
	
	/*
	 * Returns the distinct product entry whose name is given as a method parameter
	 * If no product entry is found ,this method returns null
	 */
	Product findDistinctByName(String name);
	
	/*
	 * Returns the products whose price is greater than given price as method parameter
	 * @Param price
	 * @return
	 */
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	
	/*
	 * Returns the products whose price is Less than given price as method parameter
	 * @Param price
	 * @return
	 */
	List<Product> findByPriceLessThan(BigDecimal price);
	
	/*
	 * Returns the filtered the product record  that match the given text
	 * @Param price
	 * @return
	 */
	List<Product> findByNameContaining(String name);
	
	/*
	 * Returns products based on SQL Like condition
	 * @Param name
	 * @retrun
	 */
	List<Product> findByNameLike(String name);
	
	
	/*
	 * Returns a product whose price between start price and end price
	 * @param startPrice
	 * @param endPrice
	 * @return
	 */
	List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
	
	
	/*
	 * Returns a product whose dateCreated between start date and end date
	 * @param startPrice
	 * @param endPrice
	 * @return
	 */
	List<Product> findByDataCreatedBetween(LocalDateTime startDate , LocalDateTime endDate);
	
	/*
	 * Returns list of products based on multiple values
	 * @Param names
	 * @return
	 */
	List<Product> findByNameIn( List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();
    
    List<Product> findFirst3ByOrderByNameAsc();
}
