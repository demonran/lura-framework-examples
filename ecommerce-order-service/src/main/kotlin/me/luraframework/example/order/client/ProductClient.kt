package me.luraframework.example.order.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "ecommerce-product-service")
interface ProductClient {

   @GetMapping("/product/product/{id}")
   fun queryById(@PathVariable id: Long):ProductResponse?
}
