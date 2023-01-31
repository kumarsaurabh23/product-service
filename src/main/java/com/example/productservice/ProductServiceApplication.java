package com.example.productservice;

import com.example.productservice.dao.ProductDao;
import com.example.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProductServiceApplication.class, args);
		ProductDao dao = context.getBean(ProductDao.class);
		dao.saveAll(getInitialProducts());
	}

	private static List<Product> getInitialProducts() {
		Product p1 = new Product(null, "apple", "Laptops", "New", 1000d, "macbook", LocalDate.now());
		Product p2 = new Product(null, "samsung", "Phones", "New", 999d, "phone", LocalDate.now());
		return Arrays.asList(p1, p2);
	}

}
