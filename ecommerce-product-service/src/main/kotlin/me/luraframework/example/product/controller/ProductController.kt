package me.luraframework.example.product.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController {

  private val logger:Logger = LoggerFactory.getLogger(ProductController::class.java)

  @GetMapping("{id}")
  fun query(@PathVariable id: String): String {
    logger.info("product's id is $id")
    return "product's id is $id"
  }
}
