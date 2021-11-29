package me.luraframework.example.order

import me.luraframework.boot.LuraFramework
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@LuraFramework
class Application {

  private var log: Logger = LoggerFactory.getLogger(Application::class.java)

  @Bean
  @LoadBalanced
  fun restTemplate(): RestTemplate {
    return RestTemplate()
  }
}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
