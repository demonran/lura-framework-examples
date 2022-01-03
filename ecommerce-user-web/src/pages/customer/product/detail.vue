<template>
  <p>商品详情</p>
  <div>
    <div class="intro">
      <div class="intro-lf">
        <img src="https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-silver.png"/>
      </div>
      <div class="intro-rt">
        <h3 style="font-size: 22px">{{ product.name }}</h3>
        <p style="color: #b0b0b0; height: 100px">{{ product.intro }}</p>
        <div class="intro-price">{{ product.price }} 元</div>
        <div style="height: 100px; float: right">
          <el-button @click="buy=true">立即购买</el-button>
          <el-button>加入购物车</el-button>
        </div>

      </div>
    </div>
  </div>
  <el-dialog :model-value="buy">
    <div>
      <el-input-number></el-input-number>
      <el-button @click="createOrder">确认</el-button>
    </div>


  </el-dialog>
</template>

<script setup>
import {useRoute} from "vue-router";
import {onMounted, reactive, ref} from "vue";
import productApi from '../../../api/product.js'
import OrderApi from '../../../api/order.js'

const route = useRoute()
const {get} = {...productApi}
const {add: addOrder} = {...OrderApi}
const product = reactive({id: undefined})
const orderParams = reactive({count: 1, productId: undefined})
const buy = ref(false)

onMounted(() => {
  const productId = route.params.id
  get({id: productId}).then(res => Object.assign(product, res))
})

const createOrder = () => {
  orderParams.productId = product.id
  addOrder(orderParams).then(res => {
    buy.value = false
  })
}

</script>

<style lang="scss" scoped>
.intro {
  display: flex;
  height: 500px;

  .intro-lf {
    height: 100%;
  }

  .intro-rt {
    background: #f8f8f8;
    width: 520px;
    float: right;
    padding: 20px 50px;

    .intro-price {
      font-size: 18px;
      color: #1baeae;
      font-weight: bold;
      float: right;
      height: 100px;
      padding-left: 400px;
    }
  }
}

</style>
