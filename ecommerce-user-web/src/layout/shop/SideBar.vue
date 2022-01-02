<template>
  <el-menu router class="side-bar-container">
    <el-menu-item index="/shop/">
      首页
    </el-menu-item>
      <el-menu-item index="/shop/product">
        商品列表
      </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "SideBar"
}
</script>

<style scoped>
  .side-bar-container {
    height: 100%;
  }
</style>
