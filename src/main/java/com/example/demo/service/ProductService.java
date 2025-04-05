package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.entites.Product;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Page<Product> findProducts(int offset, int pagesize) {
		return productRepository.findAll(PageRequest.of(offset, pagesize));
	}
@Transactional
	public String addProduct(ProductDto productDto) {
		Product build = null;
		if (productDto != null) {
			try {
				build = Product.build().setBrandName(productDto.getBrandName()).setCategory(productDto.getCategory())
						.setPrice(productDto.getPrice()).setTitle(productDto.getTitle()).build();
			} catch (Exception e) {
				throw new BadRequestException("bad request");
			}
		} else {
			throw new BadRequestException("bad request");
		}
		productRepository.save(build);
		return "Product saved sucessfully";
	}

public Page<Product> findActiveproducts(int offset,int pagesize){
	Pageable pg =PageRequest.of(offset, pagesize);
return	productRepository.getAllProductsPage(pg);
}

}
