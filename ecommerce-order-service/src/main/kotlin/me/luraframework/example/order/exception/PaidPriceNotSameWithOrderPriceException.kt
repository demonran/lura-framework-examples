package me.luraframework.example.order.exception

import com.google.common.collect.ImmutableMap
import me.luraframework.commons.exception.AppException

class PaidPriceNotSameWithOrderPriceException(id: Long) :
  AppException(OrderErrorCode.PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE, mapOf("orderId" to id))
