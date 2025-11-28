package com.example.high_five.controller;

import com.example.high_five.dto.coupon.MemberCouponResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String myPage(@RequestParam(value = "tab", defaultValue = "info") String tab, Model model) {
        List<MemberCouponResponseDto> myCoupons = Arrays.asList(
                new MemberCouponResponseDto(1L, "생일 축하 쿠폰", "ISSUED", 10000L, LocalDateTime.of(2025, 12, 31, 23, 59), "5만원 이상 구매 시"),
                new MemberCouponResponseDto(2L, "특별 감사 쿠폰", "ISSUED", 5000L, LocalDateTime.of(2025, 11, 30, 23, 59), "최대 5,000원 할인"),
                new MemberCouponResponseDto(3L, "첫 구매 환영 쿠폰", "USED", 3000L, LocalDateTime.of(2025, 10, 15, 0, 0), "조건 없음"),
                new MemberCouponResponseDto(4L, "오픈 기념 쿠폰", "EXPIRED", 1000L, LocalDateTime.of(2025, 9, 30, 23, 59), "모든 도서 적용 가능")
        );

        model.addAttribute("currentTab", tab);
        model.addAttribute("myCoupons", myCoupons);
        model.addAttribute("couponCount", myCoupons.size());

        return "order/mypage";
    }
}
