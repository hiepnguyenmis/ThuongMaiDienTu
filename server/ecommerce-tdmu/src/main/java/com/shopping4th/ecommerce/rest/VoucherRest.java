package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.entity.Vouchers;
import com.shopping4th.ecommerce.service.VoucherService;

@RestController
@RequestMapping(value = "/api/vouchers")
@CrossOrigin
public class VoucherRest {
	
	
	private VoucherService voucherService;
	@Autowired
	public VoucherRest(VoucherService voucherService) {
	
		this.voucherService = voucherService;
	}

	@GetMapping()
	public List<Vouchers> getProductByCategoryId(Pageable pageable){
		return this.voucherService.findAll(pageable);
	} 
	
	@GetMapping("/{id}")
	public Vouchers getVoucherById(@PathVariable Long id){
		boolean isVoucher = this.voucherService.existsById(id);
		if(!isVoucher) {
			throw new RuntimeException("Voucher "+ id + " is not found");
		}
		return this.voucherService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVoucher(@PathVariable Long id) {
		this.voucherService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Vouchers updateProduct(@PathVariable Long id, @RequestBody Vouchers vouchers) {
		if(!voucherService.existsById(id)) {
			throw new EntityNotFoundException("Voucher "+ id + " is not found");
		}
		
		vouchers.setId(id);
		voucherService.save(vouchers);
		return this.voucherService.findById(id);
	}
	
	@PostMapping()
	public Vouchers createVoucher(@Valid @RequestBody Vouchers vouchers) {
		
		voucherService.save(vouchers);
		return voucherService.findById(vouchers.getId());
	}
	
	
	

}
