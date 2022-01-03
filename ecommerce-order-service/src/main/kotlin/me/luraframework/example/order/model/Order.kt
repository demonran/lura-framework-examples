package me.luraframework.example.order.model

import java.math.BigDecimal
import java.time.Instant
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "ecommerce_order")
data class Order(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long?,
  val customerId: Long,
  val shopId: Long,
  @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
  @JoinColumn(name = "order_id")
  val orderItems: List<OrderItem>,
  val totalPrice: BigDecimal,
  @Enumerated(EnumType.STRING)
  val status: OrderStatus,
  val createdAt: Instant,
) {
  constructor(orderItems: List<OrderItem>, shopId: Long, customerId: Long) : this(
    id = null,
    customerId = customerId,
    shopId = shopId,
    orderItems = orderItems,
    totalPrice = orderItems.sumOf { it.itemPrice.multiply(BigDecimal(it.count)) },
    status = OrderStatus.CREATED,
    createdAt = Instant.now()
  )
}

enum class OrderStatus {
  CREATED, PAID
}
