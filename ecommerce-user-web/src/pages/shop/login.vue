<template>
  <div class="login" :style="'background-image:url('+ Background +');'">
    <el-card class="login-form">
      <template #header>
        <div class="login-header">
          <span>商家登陆</span>
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
import Auth from '@/api/shop/auth.js'
import { useRoute, useRouter } from 'vue-router'
import {reactive} from "vue";
export default {
  name: "login",
  setup() {
    const {login} = {...Auth}
    const route = useRouter()

    const form = reactive({})

    const handleLogin = () => {
      login(form).then(res => {
        localStorage.setItem("token", res)
        route.push('/shop')
      })
    }

    return {
      form,
      handleLogin
    }
  },

  data() {
    return {
      Background: Background,
    }
  },
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
