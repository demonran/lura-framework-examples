package me.luraframework.example.order.controller

import io.luraframework.security.annotation.UserContext
import io.luraframework.security.model.BusinessJwtUser
import me.luraframework.example.order.OrderService
import me.luraframework.example.order.command.CreateOrderCommand
import me.luraframework.example.order.command.ShipOrderCommand
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
@RequestMapping("shop/order")
class ShopOrderController(
  val orderService: OrderService
) {
  private val logger: Logger = LoggerFactory.getLogger(ShopOrderController::class.java)

  @GetMapping("{id}")
  fun getOrder(@PathVariable id: Long, @UserContext jwtUser: BusinessJwtUser): Order {
    return orderService.findById(id, jwtUser.id);
  }

  @GetMapping
  fun listOrder( @UserContext jwtUser: BusinessJwtUser): List<Order> {
    return orderService.findByShopId(jwtUser.id);
  }

  @PostMapping("{id}/shipment")
  fun shipOrder(@PathVariable id: Long, @RequestBody command: ShipOrderCommand, @UserContext jwtUser: BusinessJwtUser): Order {
    return orderService.shipOrder(id, jwtUser.id, command);
  }


}
