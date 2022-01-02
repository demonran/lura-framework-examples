package me.luraframework.example.product.config

import io.luraframework.security.model.BusinessJwtUser
import me.luraframework.core.commons.JsonUtils
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer


class TokenToBusinessUserMethodArgumentResolver : HandlerMethodArgumentResolver {
  override fun supportsParameter(parameter: MethodParameter): Boolean {
    if (parameter.hasParameterAnnotation(BusinessUser::class.java)) {
      return true
    }
    return false
  }

  override fun resolveArgument(
    parameter: MethodParameter,
    mavContainer: ModelAndViewContainer?,
    webRequest: NativeWebRequest,
    binderFactory: WebDataBinderFactory?
  ): Any? {
    val userInfo = webRequest.getHeader("userInfo")
    return JsonUtils.toObj(userInfo, BusinessJwtUser::class.java)
  }
}
