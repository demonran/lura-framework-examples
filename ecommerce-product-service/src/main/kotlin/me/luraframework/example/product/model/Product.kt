package me.luraframework.example.product.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ecommerce_product")
data class Product(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val name: String,
  val intro: String,
  val cover: String,
  val stock: Long,
  val price: BigDecimal,
  @Enumerated(EnumType.STRING)
  val status: ProductStatus,
  val shopId: Long
)
