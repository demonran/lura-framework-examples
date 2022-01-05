package me.luraframework.example.order.exception

import me.luraframework.commons.exception.ErrorCode

enum class OrderErrorCode(private val status: Int, private val message: String) : ErrorCode {
  PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE(409, "支付价格与订单实际价格不符"),
  ORDER_NOT_FOUND(404, "订单没有找到");

  override fun getStatus(): Int {
    return this.status
  }

  override fun getCode(): String {
    return this.name
  }

  override fun getMessage(): String {
    return this.message
  }
}

