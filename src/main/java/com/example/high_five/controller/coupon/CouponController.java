package com.example.high_five.controller.coupon;

import com.example.high_five.dto.coupon.CouponTemplateDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CouponController {

    @GetMapping("/coupon")
    public String couponRegisterPage(Model model){
        List<CouponTemplateDto> templates = Arrays.asList(
                new CouponTemplateDto(100L, "신규 도서 10% 할인", "최대 5,000원 할인 | 유효기간 30일", 10, "PERCENTAGE"),
                new CouponTemplateDto(101L, "첫 구매 감사 3,000원", "5,000원 이상 구매 시 사용 가능", 3000, "FIXED")
        );

        model.addAttribute("templates", templates);
        return "order/coupon-register";
    }

    @PostMapping("/coupon/issue")
    public String issueCoupon(@RequestParam Long couponId) {
        // TODO: 백엔드 API (POST /coupons/issue) 호출
        System.out.println("쿠폰 발급 요청: " + couponId);

        return "redirect:/mypage?tab=coupons"; // 발급 후 마이페이지 쿠폰탭으로 이동
    }
}
