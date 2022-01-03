package me.luraframework.example.product.config

import io.luraframework.security.handler.JwtUserMethodArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig: WebMvcConfigurer {
  override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
    argumentResolvers.add(JwtUserMethodArgumentResolver())
    super.addArgumentResolvers(argumentResolvers);
  }


}
