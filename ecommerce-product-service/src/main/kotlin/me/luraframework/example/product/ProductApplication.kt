package me.luraframework.example.product

import me.luraframework.boot.LuraFramework
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@LuraFramework
class Application {

  private var log: Logger = LoggerFactory.getLogger(Application::class.java)


  @GetMapping("/{name}")
  fun appName(@PathVariable name: String): String {
    log.info("your name is $name")
    return "your name is $name"
  }
}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
