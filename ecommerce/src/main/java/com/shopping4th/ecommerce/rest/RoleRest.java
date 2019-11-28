package com.shopping4th.ecommerce.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Role;
import com.shopping4th.ecommerce.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleRest {

	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public Set<Role> getAllByName(@RequestParam String name){
		return this.roleService.findByName(name);
	}
}
