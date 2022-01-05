package me.luraframework.example.order.model

import me.luraframework.example.order.exception.PaidPriceNotSameWithOrderPriceException
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
class Order(orderItems: List<OrderItem>, shopId: Long, customerId: Long){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null
  val customerId: Long
  val shopId: Long
  @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
  @JoinColumn(name = "order_id")
  val orderItems: List<OrderItem>
  val totalPrice: BigDecimal
  val createdAt: Instant
  @Enumerated(EnumType.STRING)
  var status: OrderStatus

  init {
    this.customerId = customerId
    this.shopId = shopId
    this.orderItems = orderItems
    this.createdAt = Instant.now()
    this.status = OrderStatus.CREATED
    this.totalPrice = orderItems.sumOf { it.itemPrice.multiply(BigDecimal(it.count)) }
  }

  fun pay(payPrice: BigDecimal) {
    if (totalPrice.toDouble() != payPrice.toDouble()) {
      throw PaidPriceNotSameWithOrderPriceException(this.id!!);
    }
    this.status = OrderStatus.PAID
  }
}

enum class OrderStatus {
  CREATED, PAID
}
