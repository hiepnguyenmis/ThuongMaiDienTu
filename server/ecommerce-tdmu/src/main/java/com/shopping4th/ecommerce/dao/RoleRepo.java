package com.shopping4th.ecommerce.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	public Set<Role> findByName(String name);
	
}
