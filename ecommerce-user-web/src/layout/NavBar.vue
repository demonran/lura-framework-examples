<template>
  <div class="navbar">
    <div class="navbar-item">登陆</div>
    <div class="navbar-item" @click="toOrder">我的订单</div>


  </div>
</template>

<script setup>

import {useRoute, useRouter} from "vue-router";

const router = useRouter()
const route = useRoute()

const toOrder = () => {
  const currentPath = route.path
  if (currentPath === '/order') {
    location.reload()
  }else {
    router.push('/order');
  }
}

</script>

<style lang="scss" scoped>
.navbar {
  width: 1266px;;

  .navbar-item {
    float: right;
    margin-right: 20px;
    font-size: 16px;
    cursor: pointer;
  }
}
</style>
