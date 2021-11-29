package me.luraframework.example.product.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController {

  @GetMapping("{id}")
  fun query(@PathVariable id: String): String {
    return "product's id is $id"
  }
}
