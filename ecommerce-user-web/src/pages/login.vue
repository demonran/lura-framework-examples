<template>
  <div class="login" :style="'background-image:url('+ Background +');'">
    <el-card class="login-form">
      <template #header>
        <div class="login-header">
          <span>登陆</span>
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
          <el-button  size="medium" type="primary" style="width:100%;" @click="handleLogin">
            <span >登 录</span>
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import Background from '@/assets/background.jpg'
import AuthApi from '@/api/auth.js'
import {setUserInfo} from "../utils/user.js";

const { login } = {...AuthApi}
export default {
  name: "login",
  data() {
    return {
      form: {},
      Background: Background,
    }
  },
  methods: {
    handleLogin() {
      login(this.form).then(res => {
        setUserInfo(res)
        this.$router.push('/')
      })
    }
  }
}
</script>

<style rel="stylesheet/scss"  scoped lang="scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-size: cover;

  .login-form {
    width: 385px;

    .login-header {
      text-align: center;
    }
  }
}

</style>
