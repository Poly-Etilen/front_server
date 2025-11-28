package com.example.high_five.controller.order;

import com.example.high_five.dto.coupon.MemberCouponResponseDto;
import com.example.high_five.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final CouponService couponService; // Feign Client 주입

    @GetMapping("/mypage")
    public String myPage(@RequestParam(value = "tab", required = false) String tab, Model model) {
        
        // 쿠폰 서버에 요청을 보내 데이터 가져오기
        List<MemberCouponResponseDto> coupons = couponService.getMyCoupons();
        
        // 모델에 담아서 타임리프로 전달
        model.addAttribute("coupons", coupons);
        model.addAttribute("currentTab", tab);
        
        return "order/mypage";
    }
}