package me.luraframework.example.order

import me.luraframework.example.order.client.ProductClient
import me.luraframework.example.order.command.CreateOrderCommand
import me.luraframework.example.order.model.Order
import me.luraframework.example.order.model.OrderRepository
import me.luraframework.example.order.model.OrderStatus
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService(
  val productClient: ProductClient,
  val orderRepository: OrderRepository
) {

  fun createOrder(command: CreateOrderCommand): Order {
    val productResponse = productClient.queryById(command.productId)
    val order = Order(
      id = null,
      productId = productResponse?.id ?: throw RuntimeException(),
      shopId = productResponse.shopId?: throw RuntimeException(),
      count = command.count,
      status = OrderStatus.CREATED
    )
    return orderRepository.save(order)
  }

  fun findById(id: Long): Order {
    return orderRepository.findById(id).orElseThrow { RuntimeException() }
  }
}
