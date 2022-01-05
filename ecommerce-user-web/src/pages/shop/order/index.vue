<template>
  <div>
    <el-card v-for="order in crud.data" class="order">
      <div class="order-shop">
        <p>商家： {{ order.shopId }}</p>
        <p>订单状态： {{ ORDER_STATUS[order.status] }}</p>
        <p>创建时间： {{ order.createdAt }}</p>
      </div>
      <el-row>
        <el-col :span="18" class="order-item" v-for="item in order.orderItems">
          <img style="width: 140px" src="https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-silver.png"
               class="image"/>
          <div class="order-item-description">
            <div>
              <p>商品名称</p>
              <p>{{ item.productName }}</p>
            </div>
            <div>
              <p>商品数量</p>
              <p>{{ item.count }}</p>
            </div>
            <div>
              <p>商品价格</p>
              <p>{{ item.itemPrice }}</p>
            </div>

          </div>
        </el-col>
        <el-col :span="2">运单号: {{ order.shipNumber  }} </el-col>
        <el-col :span="2">订单总价： {{ order.totalPrice }}</el-col>
        <el-col :span="2">
          <el-button v-if="order.status === 'PAID'" style="height: 20px" @click="toShip(order)">发货</el-button>
        </el-col>
      </el-row>


    </el-card>
  </div>
</template>

<script>
import OrderApi from '@/api/shop/order.js'
import udOperation from '@/components/crud/UD.operation.vue'
import {useCrudProvider} from "../../../components/crud/crud.js";
import crudOperation from "../../../components/crud/CRUD.operation.vue"
import {ORDER_STATUS} from "../../../config/order.config.js"
import {ElMessageBox} from "element-plus/lib/components/index.js";

export default {
  name: "index",
  components: {crudOperation, udOperation},

  setup() {
    const crud = useCrudProvider({crudMethod: {...OrderApi}});
    const {ship} = {...OrderApi}

    const toShip = (order) => {
      ElMessageBox.prompt('请输入运单号', '发货', {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
      })
          .then(({ value }) => {
            ship({id: order.id, shipNumber: value}).then(res => {
              crud.refresh()
            })
          })
          .catch(() => {})
    }

    return {
      crud,
      ORDER_STATUS,
      toShip
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
  .order-detail {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .order-item {
    display: flex;
    .order-item-description {
      width: 800px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
  }

}
</style>
