package com.shopping4th.ecommerce.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeRest {

	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public String welcome() {
		return "Trang api web Thương mại điện tử. Danh sách Api: https://aqueous-retreat-01787.herokuapp.com/swagger-ui.html";
	}
}
