<template>
  <div class="register" :style="'background-image:url('+ Background +');'">
    <el-card class="register-form">
      <template #header>
        <div class="register-header">
          <span>注册</span>
        </div>
      </template>
      <el-form>
        <el-form-item >
          <el-input v-model="form.username" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input v-model="form.password" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input v-model="form.confirm" placeholder="确认密码"></el-input>
        </el-form-item>
        <el-form-item >
          <el-button  size="medium" type="primary" style="width:100%;" @click="handleRegister">
            <span >注册</span>
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import Background from '@/assets/background.jpg'
import { register } from '@/api/register.js'
export default {
  name: "register",
  data() {
    return {
      form: {},
      Background: Background,
    }
  },
  methods: {
    handleRegister() {
      if(this.form.password === this.form.confirm ) {
        register(this.form).then(res => {
          console.log(res)
        })
      }
    }
  }
}
</script>

<style rel="stylesheet/scss"  scoped lang="scss">
.register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-size: cover;

  .register-form {
    width: 385px;

    .register-header {
      text-align: center;
    }
  }
}

</style>
