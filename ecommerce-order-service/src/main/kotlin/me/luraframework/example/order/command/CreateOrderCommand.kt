package me.luraframework.example.order.command

 data class CreateOrderCommand(
   val productId: Long,
   val count: Int,
 )
