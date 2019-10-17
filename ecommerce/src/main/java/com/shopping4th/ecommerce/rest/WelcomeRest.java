package com.shopping4th.ecommerce.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeRest {

	@GetMapping
	public String welcome() {
		return "Trang api web Thương mại điện tử. Danh sách Api: https://documenter.getpostman.com/view/8563174/SVtSW9tH?version=latest";
	}
}
