package me.luraframework.example.product.controller

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
  fun query(@PathVariable id: Long): Product? {
    logger.info("product's id is $id")
    return productService.findById(id)
  }

  @GetMapping
  fun list(): List<Product> {
    return productService.findAll();
  }

  @PostMapping
  fun createProduct(@RequestBody product: Product): Product {
    return productService.save(product)
  }

  @PutMapping("{id}")
  fun updateProduct(@PathVariable id: Long, @RequestBody product: Product):Product {
    return productService.update(id, product);
  }

  @DeleteMapping("{id}")
  fun deleteProduct(@PathVariable id: Long) {
    productService.delete(id)
  }

  @PutMapping("{id}/put-on")
  fun putOnProducts(@PathVariable id: Long): Product {
    return productService.putOn(id);
  }

  @PutMapping("{id}/put-off")
  fun putOffProducts(@PathVariable id: Long): Product {
    return productService.putOff(id);
  }
}
