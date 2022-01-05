package me.luraframework.example.order

import me.luraframework.boot.LuraBootApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@LuraBootApplication
@EnableFeignClients
class OrderApplication {

  @Bean
  @LoadBalanced
  fun restTemplate(): RestTemplate {
    val restTemplate = RestTemplate()
    return restTemplate
  }
}

fun main(args: Array<String>) {
  runApplication<OrderApplication>(*args)
}
