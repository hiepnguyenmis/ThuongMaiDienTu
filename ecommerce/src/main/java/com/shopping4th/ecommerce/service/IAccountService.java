package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.UserDto;

public interface IAccountService {

	public List<Accounts> findALl();
	//public void save(Accounts accounts);
	public void save(UserDto user);
	public boolean existsById(Long id);
	public Accounts findById(Long id);
	public Accounts findByEmail(String email);
	public boolean existsByEmail(String email);
}
