package com.rana.springboot.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rana.springboot.model.Coupon;

//@FeignClient("COUPON-SERVICE")
@FeignClient("GATEWAY-SERVICE")
//@RibbonClients("COUPON-SERVICE")
//@FeignClient("zuul-api-gateway")
public interface CouponClient {
	
	//This is for @FeignClient("COUPON-SERVICE"),@FeignClient("GATEWAY-SERVICE"),@RibbonClients("COUPON-SERVICE")
	
	  @GetMapping("/couponapi/coupons/{code}") 
	  Coupon getCoupon(@PathVariable("code") String code);
	 
	
	//This is for @FeignClient("zuul-api-gateway")
	
	/*
	 * @GetMapping("/coupon-service/couponapi/coupons/{code}") Coupon
	 * getCoupon(@PathVariable("code") String code);
	 */

}
