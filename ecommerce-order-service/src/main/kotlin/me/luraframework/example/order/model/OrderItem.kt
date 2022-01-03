package me.luraframework.example.order.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ecommerce_order_item")
data class OrderItem(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val productId: Long,
  val productName: String,
  val itemPrice: BigDecimal,
  val count: Int,
)
