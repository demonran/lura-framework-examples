package me.luraframework.example.order.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {

  fun findByShopId(shopId: Long):List<Order>

  fun findByCustomerId(customerId: Long): List<Order>

  fun findByIdAndCustomerId(id: Long, customerId: Long): Order?

  fun findByIdAndShopId(id: Long, shopId: Long): Order?

}
