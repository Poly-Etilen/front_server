package com.example.high_five.service;

import com.example.high_five.controller.coupon.CouponCreateRequestDto;
import com.example.high_five.controller.coupon.CouponPolicyResponseDto;
import com.example.high_five.controller.coupon.UserCouponIssueRequestDto;
import com.example.high_five.dto.coupon.CouponPolicyRequestDto;
import com.example.high_five.dto.coupon.CouponTemplateDto;
import com.example.high_five.dto.coupon.MemberCouponResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "COUPON-SERVER")
public interface CouponService {

    @GetMapping("/api/coupons/members/{memberId}")
    Map<String, Object> getMemberCoupons(@PathVariable("memberId") Long memberId,
                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "size", defaultValue = "10") int size);

    @GetMapping("/api/admin/coupons")
    List<CouponTemplateDto> getAdminCoupons();

    @GetMapping("/api/coupons/templates")
    Map<String, Object> getIssuableCoupons(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size);

    @PostMapping("/api/admin/coupon-policy")
    void createCouponPolicy(@RequestBody CouponPolicyRequestDto dto);

    @PostMapping("/api/coupons/issue")
    void issueCoupon(@RequestHeader("X-USER-ID") Long userId,
                     @RequestBody UserCouponIssueRequestDto requestDto);

    @GetMapping("/api/admin/coupon-policy")
    List<CouponPolicyResponseDto> getAllPolicies();

    @PostMapping("/api/admin/coupons")
    void createCouponTemplate(@RequestBody CouponCreateRequestDto dto);
}
