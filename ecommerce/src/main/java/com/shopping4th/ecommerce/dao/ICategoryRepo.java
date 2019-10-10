package com.shopping4th.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Category;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {

}
