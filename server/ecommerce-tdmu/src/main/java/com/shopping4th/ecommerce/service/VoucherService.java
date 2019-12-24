package com.shopping4th.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.shopping4th.ecommerce.entity.Vouchers;

public interface VoucherService {


	public List<Vouchers> findAll(Pageable pageable);
	public Vouchers findById(Long id);
	public void save(Vouchers vouchers);
	public void deleteById(Long id);
	public boolean existsById(Long id);
}
