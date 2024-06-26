package com.dev.api_eventos.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.api_eventos.domain.coupon.Coupon;
import com.dev.api_eventos.domain.coupon.CouponRequestDTO;
import com.dev.api_eventos.domain.event.Event;
import com.dev.api_eventos.repositories.CouponRepository;
import com.dev.api_eventos.repositories.EventRepository;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponDTO){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found!"));

        Coupon coupon = new Coupon();
        coupon.setCode(couponDTO.code());
        coupon.setDiscount(couponDTO.discount());
        coupon.setValid(new Date(couponDTO.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

}
