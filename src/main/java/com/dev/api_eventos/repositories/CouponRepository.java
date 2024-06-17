package com.dev.api_eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.api_eventos.domain.coupon.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, UUID>{

}
