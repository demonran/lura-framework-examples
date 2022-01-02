<template>
  <el-row>
    <el-col :span="1">
    </el-col>
    <el-col :span="23">
      <app-main></app-main>
    </el-col>
  </el-row>
</template>

<script>
import AppMain from "./app-main.vue";
export default {
  name: "index",
  components: {AppMain},

}
</script>

<style scoped>

</style>
