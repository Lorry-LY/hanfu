<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <el-row>
      <el-button type="primary" @click="btn_login">登录测试</el-button>
      <el-button type="primary" @click="btn_haveToken">带Token接口测试</el-button>
      <el-button type="primary" @click="btn_noToken">不带Token接口测试</el-button>
      <el-button type="primary" @click="btn_logout">登出测试</el-button>
    </el-row>
    <el-row>
      <el-row>
        <el-col :span="6"><el-label>手机号：</el-label></el-col>
        <el-col :span="18"><el-input label="手机号" v-model="phoneNumber" placeholder="请输入手机号" /></el-col>
      </el-row>
      <el-row>
        <el-col :span="5"><el-label>验证码：</el-label></el-col>
        <el-col :span="14"><el-input label="验证码" v-model="verify" placeholder="验证码" /></el-col>
        <el-col :span="5"><el-button type="primary" @click="get_verify">获取验证码</el-button></el-col>
      </el-row>
      <el-row>
        
      </el-row>
    </el-row>
  </div>
</template>

<script>
import {login,logout,notoken,havetoken,get_verify} from '@/utils/http/api'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      res:null,
      phoneNumber:"",
      verify:""
    }
  },
  methods: {
    async btn_login() {
      // const res = await login({userID:"123",user:"zhangsan",password:"123456"})
      // console.log(res)
      await login({userID:"123",user:"zhangsan",password:"123456"})
    },
    async btn_logout() {
      // const res = await logout({userID:"123"})
      // console.log(res)
      this.res = await logout({userID:"123"})
    },
    async btn_noToken() {
      // const res = await notoken()
      // console.log(res)
      await notoken()
    },
    async btn_haveToken() {
      // const res = await havetoken()
      // console.log(res)
      this.res = await havetoken()
    },
    async get_verify() {
      this.res = await get_verify({
        phoneNumber:this.phoneNumber,
        state:"login"
      }).then(data=>{
        this.verify = data.code;
      })
      
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
