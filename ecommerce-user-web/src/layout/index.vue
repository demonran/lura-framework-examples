<template>
  <el-container class="main-container">
    <el-header></el-header>
    <el-main class="main-wrapper">
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import AppMain from "./app-main.vue";
export default {
  name: "index",
  components: {AppMain},

}
</script>

<style lang="scss" scoped>
.el-container {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  width: 100%;
  .el-main {
    width: 1266px;
    flex-shrink: 0;
  }
}

</style>
