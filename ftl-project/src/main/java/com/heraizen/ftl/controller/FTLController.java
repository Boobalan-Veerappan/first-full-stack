package com.heraizen.ftl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.heraizen.ftl.configuration.Product;


@RestController

public class FTLController {

	@GetMapping("/product/")
	public List<Product> product() {
		Product p1 = new Product("lap", "www.laptop.com11");
		Product p2 = new Product("lap", "www.laptop.com");
		Product p3 = new Product("lap", "www.laptop.com");
		List<Product> pro = new ArrayList<>();

		pro.add(p1);
		pro.add(p2);
		pro.add(p3);

		return pro;
	}

	@GetMapping("/string/")
	public String print() {
		return "boobalan";
	}
}
