package com.furniture.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.exception.EmptyOrderException;
import com.furniture.exception.InvalidDetailsException;
import com.furniture.exception.ProductNotFoundException;
import com.furniture.bean.Product;
import com.furniture.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepo;


	@Override
	public List<Product> AllProducts() {
		log.info("Entered viewAllProducts of Product service is called", System.currentTimeMillis());
		List<Product> allProducts = productRepo.findAll();
		if(allProducts.isEmpty()) {
			throw new EmptyOrderException("No Products Found");
		}

		return allProducts;
	}

	@Override
	public Product addProduct(Product product) {
		log.info("Entered addProduct of Product service is called", System.currentTimeMillis());
		if(product == null)
			throw new ProductNotFoundException("No Products Found");
		else {
			productRepo.save(product);

			return  product;
		}
	}

	@Override
	public Product updateProduct(Product product) {
		log.info("Entered updated Productsof Product service is called", System.currentTimeMillis());
		if(product == null) {
			throw new ProductNotFoundException("No Products Found");
		}else {
			productRepo.save(product);
			return product;
		}
	}

	@Override
	public Product viewProductById(long id) {
		log.info("Entered viewProductById of Product service is called", System.currentTimeMillis());
		Optional<Product> product = productRepo.findById(id);
		if(!product.isPresent()) {
			throw new InvalidDetailsException("No Products Found");
		}
		return product.get();
	}

	
	@Override
	public Product deleteProduct(long id) {
		log.info("removeProduct of Product service is called", System.currentTimeMillis());
		Optional<Product> product = productRepo.findById(id);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("No Products Found");
		}
		else {
			productRepo.deleteById(id);
			return product.get();
		}
	}

	@Override
	public Product viewProductByName(String name) {
    log.info("viewByProductName method of productServiceImpl called",System.currentTimeMillis());
		
		if(productRepo.existsByName(name))
			return productRepo.findByName(name); 
		else
			throw new InvalidDetailsException("Product with name "+name+" does not exist");
	}

	//returns list of all available products in the given category
		@Override
		public List<Product> viewProductsByCategory(String category) 
		{
			log.info("viewProductsByCategory method of productServiceImpl called",System.currentTimeMillis());
			ArrayList<Product> productList = new ArrayList<>();
			productRepo.findByCategory(category).stream().filter(p -> p.getQuantity()>0).forEach(p -> productList.add(p));
			if(productList.size()==0) {
				throw new ProductNotFoundException("Invalid category");
			}
			return productList; 
		}

}

