package me.luraframework.example.order

import com.plumelog.http.restTemplate.PlumelogRestTemplateInterceptor
import me.luraframework.boot.LuraFramework
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@LuraFramework
class Application {

  @Bean
  @LoadBalanced
  fun restTemplate(): RestTemplate {
    val restTemplate = RestTemplate()
    restTemplate.interceptors.add(PlumelogRestTemplateInterceptor())
    return restTemplate
  }
}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
