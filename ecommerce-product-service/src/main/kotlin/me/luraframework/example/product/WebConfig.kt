package me.luraframework.example.product

import com.plumelog.core.PlumeLogTraceIdInterceptor
import com.plumelog.core.TraceIdFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebConfig: WebMvcConfigurer {



  @Bean
  fun traceIdFilter(): FilterRegistrationBean<TraceIdFilter> {
    val registration: FilterRegistrationBean<TraceIdFilter> = FilterRegistrationBean<TraceIdFilter>()
    registration.filter = TraceIdFilter()
    val urlList: MutableList<String?> = ArrayList()
    urlList.add("/*")
    registration.urlPatterns = urlList
    registration.setName("CorsFilter")
    registration.order = 2
    return registration
  }

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry.addInterceptor(PlumeLogTraceIdInterceptor())
    super.addInterceptors(registry)
  }
}
