package com.eureka.seller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

	@GetMapping("/")
	public String msg() {
		return "msg";
	}
}
