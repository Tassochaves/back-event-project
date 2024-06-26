package com.dev.api_eventos.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api_eventos.domain.coupon.Coupon;
import com.dev.api_eventos.domain.coupon.CouponRequestDTO;
import com.dev.api_eventos.services.CouponService;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Coupon> addCouponsToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO couponDTO){

        Coupon coupons = couponService.addCouponToEvent(eventId, couponDTO);

        return ResponseEntity.ok(coupons);
    }
}
