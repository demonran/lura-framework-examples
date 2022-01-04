<template>
  <h1>Home</h1>
  <div>
    <p>商品列表1</p>
    <el-row>
      <el-col :span="6" v-for="product in products" >
        <el-card shadow="hover" :body-style="{ padding: '0px'}" class="product-item" @click="toDetail(product.id)">
          <img
              src="https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-silver.png"
              class="image"
          />
          <div style="padding: 14px">
            <span>{{ product.name }}</span>
            <div class="bottom">
              <time class="time">{{ product.price }}</time>
              <el-button type="text" class="button">购买</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script setup>
import productApi from '../api/product.js'
import {onMounted, ref} from "vue";
import {useRouter} from "vue-router";
const {list} = {...productApi}
const products = ref([])

onMounted(() => {
  list().then(res => products.value = res)
})
const router = useRouter()

const toDetail = (id) => {
  router.push(`/product/detail/${id}`)
}

</script>

<style scoped>
.product-item {
  margin-left: 6px;
  margin-right: 4px;
  margin-bottom: 20px;
}
.image {
  width: 100%;
  display: block;
}

</style>
