package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ProductDto;
import com.example.demo.constants.ProductContstants;
import com.example.demo.entites.Product;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

 private ProductService productService;
 @Autowired
 private ProductRepository productRepository;
	
	public ProductController(final ProductService productService) {
		this.productService=productService;
	}
	
//	@GetMapping("/save")
//	public String saveAllProducts() {
//		
//		for(int i=0;i<10;i++) {
//	Product product = new	Product();
//	product.setBrandName("zyx");
//	product.setCategory(ProductContstants.electricals);
//	product.setPrice(Double.valueOf(i));
//	product.setTitle("electricals");
//			productRepository.save(product);
//		}
//		return null;
//	}
	
	@GetMapping("/getAllProducts/{offset}/{pagesize}")
	public ResponseEntity<Page<Product>> getProducts(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize){
//		if(field==null || field.trim().isBlank()) {
//			throw new BadRequestException("sorting field must not be null");
//		}
		Page<Product> findProducts = productService.findActiveproducts(offset, pagesize);
		return new ResponseEntity<Page<Product>>(findProducts,HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto){
		//chnages in feature1
		String addProduct = productService.addProduct(productDto);
		return new ResponseEntity<String>(addProduct,HttpStatus.OK);
	}
}
