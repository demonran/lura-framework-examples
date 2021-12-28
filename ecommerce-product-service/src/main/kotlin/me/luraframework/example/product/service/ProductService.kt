package me.luraframework.example.product.service

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.model.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
  private val productRepository: ProductRepository
) {

  fun findAll(): List<Product> {
    return productRepository.findAll();
  }

  fun save(product: Product): Product {
    return productRepository.save(product)
  }


}
