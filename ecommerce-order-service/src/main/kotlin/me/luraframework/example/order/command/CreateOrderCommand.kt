package me.luraframework.example.order.command

 data class CreateOrderCommand(
   val orderItems: List<OrderItem>,
   val shopId: Long
 )

data class OrderItem(
  val productId: Long,
  val count: Int,
)


