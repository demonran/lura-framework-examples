<template>
  <div>
    <el-card v-for="order in crud.data" class="order">
      <div class="order-shop">
        <p>商家： {{ order.shopId }}</p>
        <p>订单状态： {{ ORDER_STATUS[order.status] }}</p>
        <p>创建时间： {{ order.createdAt }}</p>
      </div>
      <div class="order-item" v-for="item in order.orderItems">
        <img style="width: 140px" src="https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-silver.png" class="image"/>
        <div>
          <p>商品名称： {{ item.productName }}</p>
          <p>商品数量：{{ item.count }}</p>
          <p>商品价格： {{ item.itemPrice }}</p>
        </div>
      </div>
      <div class="order-price">
        订单总价： {{ order.totalPrice }}
      </div>


    </el-card>

  </div>
</template>

<script>
import OrderApi from '@/api/order.js'
import udOperation from '@/components/crud/UD.operation.vue'
import {useCrudProvider} from "../../../components/crud/crud.js";
import crudOperation from "../../../components/crud/CRUD.operation.vue"

export default {
  name: "index",
  components: {crudOperation, udOperation},

  setup() {
    const ORDER_STATUS = {
      CREATED: '待付款'
    }

    const crud = useCrudProvider({crudMethod: {...OrderApi}});

    return {
      crud,
      ORDER_STATUS
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
  }
  .order-price {
    float: right;
  }
}
</style>
