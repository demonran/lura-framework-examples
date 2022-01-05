package me.luraframework.example.order.exception

import me.luraframework.commons.exception.AppException

class OrderNotFoundException: AppException(
  OrderErrorCode.ORDER_NOT_FOUND
)
