package com.rana.springboot.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rana.springboot.model.Coupon;

//@FeignClient("COUPON-SERVICE")
@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
