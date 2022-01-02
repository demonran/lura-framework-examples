package me.luraframework.example.product.service

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.model.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ShopProductService(
  private val productRepository: ProductRepository
) {

  fun findAll(shopId: Long): List<Product> {
    return productRepository.findByShopId(shopId);
  }

  fun save(product: Product, shopId: Long): Product {
    return productRepository.save(product.copy(shopId = shopId))
  }

  fun findByIdAndShopId(id: Long, shopId: Long): Product? {
    return productRepository.findByIdAndShopId(id, shopId)
  }

  fun update(id: Long, resource: Product, shopId: Long): Product {
    val productInDb = productRepository.findByIdAndShopId(id, shopId) ?: throw RuntimeException()

    val newProduct = productInDb.copy(
      name = resource.name,
      intro = resource.intro,
      price = resource.price,
      status = resource.status,
      stock = resource.stock,
      cover = resource.cover
    )

    return productRepository.save(newProduct)
  }

  fun delete(id: Long, shopId: Long) {
    productRepository.deleteByIdAndShopId(id, shopId)
  }


}
