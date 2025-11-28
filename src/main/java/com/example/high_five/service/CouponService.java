package com.example.high_five.service;

import com.example.high_five.dto.coupon.MemberCouponResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "COUPON-SERVICE")
public interface CouponService {

    @GetMapping("/api/coupons/my-coupons")
    List<MemberCouponResponseDto> getMyCoupons();
}
