<template>
  <div>
      <el-table :data="products" style="width: 100%">
        <el-table-column prop="id" label="Id" width="180" />
        <el-table-column prop="name" label="商品名称" width="180" />
        <el-table-column prop="intro" label="商品简介" />
        <el-table-column prop="cover" label="图片" />
        <el-table-column prop="stock" label="库存" />
        <el-table-column prop="price" label="价格" />
        <el-table-column prop="status" label="状态" />
      </el-table>
  </div>
</template>

<script>
import {list} from '@/api/shop/product.js'
export default {
  name: "index",

  data() {
    return {
      products: [{
        id: 1,
        name: '产品1'
      }]
    }
  },
  mounted() {
    list().then(res => {
      this.products = res
    })
  }
}
</script>

<style scoped>

</style>
