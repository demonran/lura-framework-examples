<template>
  <div>
    <el-button size="small" type="primary" :icon="Plus" @click="crud.toAdd()">新增</el-button>
  </div>
</template>

<script>
import { Plus } from '@element-plus/icons-vue'
import {useCrud} from "./crud.js";
import {toRef} from "vue";

export default {

  setup(props) {
    let crud = useCrud();
    return {
      Plus,
      crud
    }
  }
}


</script>

<style scoped>

</style>
