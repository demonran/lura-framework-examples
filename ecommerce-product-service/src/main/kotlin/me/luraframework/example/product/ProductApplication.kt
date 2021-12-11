package me.luraframework.example.product

import me.luraframework.boot.LuraBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@LuraBootApplication
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
