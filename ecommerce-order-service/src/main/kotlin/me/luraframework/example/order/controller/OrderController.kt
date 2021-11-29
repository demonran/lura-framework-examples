package me.luraframework.example.order.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("order")
class OrderController(
  val restTemplate: RestTemplate
) {


  @GetMapping("{id}")
  fun getOrder(@PathVariable id:String): String {
    val product = restTemplate.getForObject("http://ecommerce-product-service/product/productId", String::class.java)

    return "order is $id, product is $product"
  }
}
