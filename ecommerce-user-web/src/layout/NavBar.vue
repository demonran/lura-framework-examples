<template>
  <div class="navbar">
    <span style="font-size: 20px; font-weight: bold">Lura商城</span>
    <router-link to="/login" v-if="!isLogin()">
      <div class="navbar-item" >登陆</div>
    </router-link>
    <el-dropdown class="navbar-item" v-else>
      <div class="avatar-wrapper">
        <el-icon :size="30"><avatar/></el-icon>
        {{ getUser().username }}
        <el-icon><caret-bottom /></el-icon>
      </div>
      <template #dropdown>
        <el-dropdown-menu>
          <router-link to="/order">
            <el-dropdown-item>我的订单</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided>退出登陆</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>


  </div>
</template>

<script setup>
import {CaretBottom, Avatar} from '@element-plus/icons-vue'
import {useRoute, useRouter} from "vue-router";

import {isLogin, getUser} from "../utils/user.js";

const router = useRouter()
const route = useRoute()

</script>

<style lang="scss" scoped>
.navbar {
  width: 1266px;
  margin: 0 auto;

  .navbar-item {
    float: right;
    margin-right: 20px;
    font-size: 16px;
    cursor: pointer;
    line-height: 60px;
    display: inline-block;

    .avatar-wrapper {
      margin-top: 5px;
      position: relative;
    }
  }
}
</style>
