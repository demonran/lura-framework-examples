<template>
  <div>
    <el-card v-for="order in crud.data" class="order">
      <div class="order-shop">
        <p>商家： {{ order.shopId }}</p>
        <p>订单状态： {{ ORDER_STATUS[order.status] }}</p>
        <p>创建时间： {{ order.createdAt }}</p>
      </div>
      <div class="order-item" v-for="item in order.orderItems">
        <img style="width: 140px" src="https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-silver.png"
             class="image"/>
        <div>
          <p>商品名称： {{ item.productName }}</p>
          <p>商品数量：{{ item.count }}</p>
          <p>商品价格： {{ item.itemPrice }}</p>
        </div>
        <div class="order-price">
          订单总价： {{ order.totalPrice }}
        </div>
      </div>
      <el-button v-if="order.status === 'CREATED'" type="primary" style="float: right; height: 20px"
                 @click="toPay(order)">付款
      </el-button>
    </el-card>

  </div>
</template>

<script>
import OrderApi from '@/api/order.js'
import udOperation from '@/components/crud/UD.operation.vue'
import {useCrudProvider} from "../../../components/crud/crud.js";
import crudOperation from "../../../components/crud/CRUD.operation.vue"
import {ElMessageBox} from 'element-plus'

export default {
  name: "index",
  components: {crudOperation, udOperation},

  setup() {
    const ORDER_STATUS = {
      CREATED: '待付款',
      PAID: '待发货'
    }

    const crud = useCrudProvider({crudMethod: {...OrderApi}});

    const {pay} = {...OrderApi}
    const doPay = (order) => {
      pay({id: order.id, payPrice: order.totalPrice}).then(res => {
        crud.refresh()
      })
    }

    const toPay = (order) => {
      ElMessageBox.confirm(`确认支付${order.totalPrice}元吗?`, '支付确认', {
        confirmButtonText: '确认',
        cancelButtonText: '取消'
      }).then(() => {
        doPay(order)
      }).catch(() => {})
    }


    return {
      crud,
      ORDER_STATUS,
      toPay
    }
  },
}
</script>

<style lang="scss" scoped>
.order {
  margin-bottom: 20px;
  padding-bottom: 20px;

  .order-shop {
    display: flex;
    justify-content: space-between;
  }

  .order-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .order-price {
    float: right;
  }
}
</style>
