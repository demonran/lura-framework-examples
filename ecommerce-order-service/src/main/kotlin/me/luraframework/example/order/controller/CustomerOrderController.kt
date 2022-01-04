package me.luraframework.example.order.controller

import io.luraframework.security.annotation.UserContext
import io.luraframework.security.model.CustomerJwtUser
import me.luraframework.example.order.OrderService
import me.luraframework.example.order.command.CreateOrderCommand
import me.luraframework.example.order.model.Order
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order")
class CustomerOrderController(
  val orderService: OrderService
) {
  private val logger: Logger = LoggerFactory.getLogger(CustomerOrderController::class.java)

  @GetMapping("{id}")
  fun getOrder(@PathVariable id: Long): Order {
    return orderService.findById(id);
  }

  @GetMapping
  fun myOrder(@UserContext jwtUser: CustomerJwtUser): List<Order> {
    return orderService.findByCustomerId(jwtUser.id);
  }

  @PostMapping
  fun createOrder(@RequestBody command: CreateOrderCommand, @UserContext jwtUser: CustomerJwtUser): Order {
    return orderService.createOrder(command, jwtUser.id)
  }
}
