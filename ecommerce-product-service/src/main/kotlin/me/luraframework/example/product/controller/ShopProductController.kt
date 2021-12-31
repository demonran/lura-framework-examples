package me.luraframework.example.product.controller

import me.luraframework.example.product.model.Product
import me.luraframework.example.product.service.ProductService
import me.luraframework.example.product.service.ShopProductService
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
@RequestMapping("shop/product")
class ShopProductController(
  val productService: ShopProductService
) {

  private val logger:Logger = LoggerFactory.getLogger(ShopProductController::class.java)

  @GetMapping("{id}")
  fun query(@PathVariable id: Long, shopId: Long): Product? {
    logger.info("product's id is $id")
    return productService.findByIdAndShopId(id, shopId)
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
}
