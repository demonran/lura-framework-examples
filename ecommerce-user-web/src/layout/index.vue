<template>
  <el-container class="main-container">
    <el-header>
      <nav-bar></nav-bar>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script setup>
import NavBar from "./NavBar.vue";

</script>

<style lang="scss" scoped>
.el-container {
  .el-main {
    margin: 0 auto;
    width: 1266px;
  }

  .el-header {
    background-color: #e3e4e5;
    color: var(--el-text-color-primary);
    line-height: 60px;
  }
}


</style>
