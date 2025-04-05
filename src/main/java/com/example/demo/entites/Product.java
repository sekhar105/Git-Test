package com.example.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id")
    private String productId;
    private String title;
    private Double price;
    private String brandName;
    private String category;
    @ColumnDefault("0")
    private long count;
    
    public static ProductBuilder build() {
    	return new ProductBuilder();
    }
    
    public static class ProductBuilder{
    	
    	private String productId;
        private String title;
        private Double price;
        private String brandName;
        private String category;
        private Long count;
    	
    	public ProductBuilder setProductid(String productId) {
    		this.productId=productId;
    		return this;
    	}
    	public ProductBuilder setTitle(String title) {
    		this.title=title;
    		return this;
    	}
    	public ProductBuilder setPrice(Double price) {
    		this.price=price;
    		return this;
    	}
    	public ProductBuilder setBrandName(String brandName) {
    		this.brandName=brandName;
    		return this;
    	}
    	public ProductBuilder setCategory(String category) {
    		this.category=category;
    		return this;
    	}
    	public Product build() {
    		return new Product(productId, title, price, brandName, category,count);
    	}
    }
}
