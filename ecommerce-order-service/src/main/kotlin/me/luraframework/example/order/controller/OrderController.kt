package me.luraframework.example.order.controller

import com.plumelog.trace.annotation.Trace
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
  private val logger: Logger = LoggerFactory.getLogger(OrderController::class.java)

  @Trace
  @GetMapping("{id}")
  fun getOrder(@PathVariable id:String): String {
    val product = restTemplate.getForObject("http://ecommerce-product-service/product/productId", String::class.java)
    logger.info("order is $id, product is $product")
    return "order is $id, product is $product"
  }
}
