package me.luraframework.example.order.client

import java.math.BigDecimal

data class ProductResponse(
  val id: Long?,
  val name: String?,
  val intro: String?,
  val cover: String?,
  val stock: Long?,
  val price: BigDecimal?,
  val status: String?,
  val shopId: Long?
)
