package me.luraframework.example.product.controller

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController(
  val productService: ProductService
) {

  private val logger:Logger = LoggerFactory.getLogger(ProductController::class.java)

  @GetMapping("{id}")
  fun query(@PathVariable id: String): String {
    logger.info("product's id is $id")
    return "product's id is $id"
  }

  @GetMapping
  fun list(): List<Product> {
    return productService.findAll();
  }

  @PostMapping
  fun createProduct(@RequestBody product: Product): Product {
    return productService.save(product)
  }
}
