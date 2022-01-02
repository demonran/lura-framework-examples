package me.luraframework.example.product.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {

  fun findByIdAndShopId(id: Long, shopId:Long): Product?

  fun findByShopId(shopId: Long): List<Product>

  fun deleteByIdAndShopId(id: Long, shopId: Long)
}
