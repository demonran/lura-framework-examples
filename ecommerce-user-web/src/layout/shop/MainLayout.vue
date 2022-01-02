<template>
  <el-container  class="main-container">
    <el-aside width="200px">
      <side-bar/>
    </el-aside>
    <el-container style="height: 100%">
      <el-header>
      </el-header>
      <el-main >
        <app-main ></app-main>
      </el-main>
      <el-footer>
        <a href="" target="_blank">github地址</a>
      </el-footer>
    </el-container>

  </el-container>

</template>

<script setup>
import SideBar from "./SideBar.vue";
import AppMain from "./AppMain.vue";
</script>

<style lang="scss" scoped>
.main-container {
  height: 100%;
}

</style>
