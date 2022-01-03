<template>
  <div>
    <el-dialog :model-value="crud.status.cu > 0" :before-close="crud.cancelCU">
      <el-form :model="crud.form">
        <el-form-item label="商品">
          <el-input v-model="crud.form.name"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="crud.form.intro"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="crud.form.cover"></el-input>
        </el-form-item>
        <el-form-item label="订单时间">
          <el-input v-model="crud.form.stock"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-input v-model="crud.form.status"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button type="text" @click="crud.cancelCU">取消</el-button>
        <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
      </template>
    </el-dialog>
    <el-table :data="crud.data" style="width: 100%">
      <el-table-column prop="id" label="Id" width="180"/>
      <el-table-column prop="count" label="数量">
        <template #default="scope">
          {{scope.row.orderItems.length}}
        </template>
      </el-table-column>
      <el-table-column prop="totalPrice" label="订单总价"/>
      <el-table-column prop="createdAt" label="时间"/>
      <el-table-column prop="status" label="状态"/>
      <el-table-column label="操作">
        <template #default="scope">
          <ud-operation :data="scope.row"/>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import OrderApi from '@/api/shop/order.js'
import udOperation from '@/components/crud/UD.operation.vue'
import {useCrudProvider} from "../../../components/crud/crud.js";
import crudOperation from "../../../components/crud/CRUD.operation.vue"

export default {
  name: "index",
  components: {crudOperation, udOperation},

  setup() {

    const crud = useCrudProvider({crudMethod: {...OrderApi}});

    return {
      crud
    }
  },
}
</script>

<style scoped>

</style>
