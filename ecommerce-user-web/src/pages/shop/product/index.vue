<template>
  <div>
    <crudOperation />
    <el-dialog :model-value="crud.status.cu > 0" :before-close="crud.cancelCU">
      <el-form :model="crud.form">
        <el-form-item label="名称">
          <el-input v-model="crud.form.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="crud.form.intro"></el-input>
        </el-form-item>
        <el-form-item label="图片">
          <el-input v-model="crud.form.cover"></el-input>
        </el-form-item>
        <el-form-item label="库存">
          <el-input v-model="crud.form.stock"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="crud.form.price"></el-input>
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
      <el-table-column prop="name" label="商品名称" width="180"/>
      <el-table-column prop="intro" label="商品简介"/>
      <el-table-column prop="cover" label="图片"/>
      <el-table-column prop="stock" label="库存"/>
      <el-table-column prop="price" label="价格"/>
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
import prductApi from '@/api/shop/product.js'
import udOperation from '@/components/crud/UD.operation.vue'
import {useCrudProvider} from "../../../components/crud/crud.js";
import crudOperation from "../../../components/crud/CRUD.operation.vue"

export default {
  name: "index",
  components: {crudOperation, udOperation},

  setup() {

    const crud = useCrudProvider({crudMethod: {...prductApi}});

    return {
      crud
    }
  },
}
</script>

<style scoped>

</style>
