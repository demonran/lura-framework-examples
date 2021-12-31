package me.luraframework.example.product.service

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.model.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ShopProductService(
  private val productRepository: ProductRepository
) {

  fun findAll(): List<Product> {
    return productRepository.findAll();
  }

  fun save(product: Product): Product {
    return productRepository.save(product)
  }

  fun findByIdAndShopId(id: Long, shopId: Long): Product? {
    return productRepository.findByIdAndShopId(id, shopId)
  }

  fun update(id: Long, resource: Product): Product {
    val productInDb = productRepository.findById(id)
      .orElseThrow { RuntimeException() }

    val newProduct = productInDb.copy(
      name = resource.name,
      intro = resource.intro,
      price = resource.price,
      status = resource.status,
      stock =  resource.stock,
      cover = resource.cover
    )

    return productRepository.save(newProduct)
  }

  fun delete(id: Long) {
    productRepository.deleteById(id)
  }


}
