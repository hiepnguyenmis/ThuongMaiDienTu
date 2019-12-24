package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.VoucherRepo;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.entity.Vouchers;

@Service
public class VoucherServiceImpl implements VoucherService {
	
	
	VoucherRepo voucherRepo;
	
	@Autowired
	public VoucherServiceImpl(VoucherRepo voucherRepo) {
		this.voucherRepo = voucherRepo;
	}

	@Override
	public List<Vouchers> findAll(Pageable pageable) {
		Page<Vouchers> vouchers = this.voucherRepo.findAll(pageable);
		return vouchers.getContent();
	}

	@Override
	public Vouchers findById(Long id) {
		Optional<Vouchers> voucher = this.voucherRepo.findById(id);
		if(voucher.isPresent()) {
			return voucher.get();
		
		}
		else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void save(Vouchers vouchers) {
		this.voucherRepo.save(vouchers);
	}

	@Override
	public void deleteById(Long id) {
		this.voucherRepo.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.voucherRepo.existsById(id);
	}

}
