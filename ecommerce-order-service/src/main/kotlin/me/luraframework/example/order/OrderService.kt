package me.luraframework.example.order

import me.luraframework.commons.exception.AppException
import me.luraframework.example.order.client.ProductClient
import me.luraframework.example.order.command.CreateOrderCommand
import me.luraframework.example.order.command.PayOrderCommand
import me.luraframework.example.order.command.ShipOrderCommand
import me.luraframework.example.order.exception.OrderNotFoundException
import me.luraframework.example.order.model.Order
import me.luraframework.example.order.model.OrderItem
import me.luraframework.example.order.model.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OrderService(
  val productClient: ProductClient,
  val orderRepository: OrderRepository
) {

  fun createOrder(command: CreateOrderCommand, customerId: Long): Order {

    val order = Order(
      orderItems = command.orderItems.map {
          val productResponse = productClient.queryById(it.productId)
          OrderItem(
            id = null,
            itemPrice = productResponse.price,
            count = it.count,
            productId = it.productId,
            productName = productResponse.name
          )
      },
      shopId = command.shopId,
      customerId = customerId,
    )
    return orderRepository.save(order)
  }


  fun findById(id: Long): Order {
    return orderRepository.findById(id).orElseThrow { RuntimeException() }
  }

  fun findById(id: Long, shopId: Long): Order {
    return orderRepository.findById(id).filter{it.shopId == shopId}
      .orElseThrow { RuntimeException() }
  }

  fun findByShopId(shopId: Long): List<Order> {
    return orderRepository.findByShopId(shopId)
  }

  fun findByCustomerId(customerId: Long): List<Order> {
    return orderRepository.findByCustomerId(customerId)
  }

  fun payOrder(id: Long, customerId: Long, command: PayOrderCommand): Order {
    val order = orderRepository.findByIdAndCustomerId(id, customerId) ?: throw OrderNotFoundException()
    order.pay(command.payPrice)
    return orderRepository.save(order)
  }

  fun shipOrder(id: Long, shopId: Long, command: ShipOrderCommand): Order {
    val order = orderRepository.findByIdAndShopId(id, shopId) ?: throw OrderNotFoundException()
    order.ship(command.shipNumber)
    return orderRepository.save(order)
  }


}
