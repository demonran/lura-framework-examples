<template>
  <el-button size="small" type="primary" :icon="Edit" @click="crud.toEdit(data)"></el-button>
  <el-popover :visible="pop" placement="top" :width="160">
    <p>确定删除本条数据吗？</p>
    <div style="text-align: right; margin: 0">
      <el-button size="small"  @click="doCancel()">取消</el-button>
      <el-button size="small" type="primary"  @click="crud.doDelete(data)">确认</el-button>

    </div>
    <template #reference>
      <el-button size="small" type="danger" :icon="Delete" @click="toDelete()"></el-button>
    </template>
  </el-popover>
</template>

<script>
import { Edit, Delete } from '@element-plus/icons-vue'
import {useCrud} from "./crud.js";
import {ref, toRef} from "vue";

export default {
  props: {
    data: {
      type: Object
    }
  },
  setup() {
    let crud = useCrud();
    const pop = ref(false)
    const doCancel = () => {
      pop.value = false
    }
    const toDelete = () => {
      pop.value = true
    }

    return {
      Edit,
      Delete,
      crud,
      pop,
      toDelete,
      doCancel
    }
  }
}


</script>

<style scoped>

</style>
