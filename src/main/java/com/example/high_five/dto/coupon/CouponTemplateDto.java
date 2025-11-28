package com.example.high_five.dto.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CouponTemplateDto {
    private Long id;
    private String name;
    private String description;
    private Integer discountValue;
    private String discountType;
}
