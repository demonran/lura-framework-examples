package me.luraframework.example.order.model

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "ecommerce_order")
data class Order(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,
  val productId: Long,
  val shopId: Long,
  val count: Int,
  @Enumerated(EnumType.STRING)
  val status: OrderStatus
)

enum class OrderStatus {
  CREATED, PAID
}
