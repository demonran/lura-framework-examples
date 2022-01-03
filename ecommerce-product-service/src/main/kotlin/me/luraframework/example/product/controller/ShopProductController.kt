package me.luraframework.example.product.controller

import io.luraframework.security.annotation.UserContext
import io.luraframework.security.model.BusinessJwtUser
import me.luraframework.example.product.model.Product
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
  fun query(@PathVariable id: Long, @UserContext user: BusinessJwtUser): Product? {
    logger.info("product's id is $id")
    return productService.findByIdAndShopId(id, user.id)
  }

  @GetMapping
  fun list(@UserContext user: BusinessJwtUser): List<Product> {
    return productService.findAll(user.id);
  }

  @PostMapping
  fun createProduct(@RequestBody product: Product, @UserContext user: BusinessJwtUser): Product {
    return productService.save(product, user.id)
  }

  @PutMapping("{id}", )
  fun updateProduct(@PathVariable id: Long, @RequestBody product: Product, @UserContext user: BusinessJwtUser):Product {
    return productService.update(id, product, user.id);
  }

  @DeleteMapping("{id}")
  fun deleteProduct(@PathVariable id: Long, @UserContext user: BusinessJwtUser) {
    productService.delete(id, user.id)
  }
}
