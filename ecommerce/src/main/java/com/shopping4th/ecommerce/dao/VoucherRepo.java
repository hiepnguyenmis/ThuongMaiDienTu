package com.shopping4th.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Vouchers;

@Repository
public interface VoucherRepo extends JpaRepository<Vouchers, Long> {

}
