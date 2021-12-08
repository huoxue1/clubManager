<template>
<div  style="width: 60%;margin-left: 10%;margin-top: 100px;border: #42b983 solid 2px var(--el-border-color-base)">
  <el-form ref="form" :model="form" label-width="140px" style="font-size: 30px">
  <el-form-item label="账号：">
    <el-input v-model="account" placeholder="请输入账号"  clearable/>
  </el-form-item>
    <el-form-item style="margin-top: 100px" label="密码：">
      <el-input v-model="password" placeholder="请输入密码" show-password clearable/>
    </el-form-item>
</el-form>

  <el-button @click="submit" type="success" style="margin-top: 100px;width: 200px;margin-bottom: 20px" >登录</el-button>
  <br>
  <el-link href="#register"  type="success">还没有账号？快来注册</el-link>
</div>
</template>

<script>
import axios from "axios";
import api from "@/api/api";
import {ElMessage} from "element-plus";


export default                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         {
  name: "Login",
  data(){
    return{
      account: "",
      password: ""
    }
  },
  methods:{
    submit:function () {
      if (this.account === "" || this.password === ""){
        return
      }
      axios.post(api.base+api.user.login,{"account":this.account,"password":this.password}).then((resp)=>{
        if (resp.data !== ""){
          sessionStorage.setItem("token",resp.data)
          ElMessage({message:"登录成功",type:"success"})
          this.$router.push("home")
        }else{
          ElMessage({message:"登录失败，密码错误或者账号不存在",type:"error"})
        }
      }).catch((err)=>{
        console.log("出现错误"+err)
        ElMessage({message:"登录出现错误",type:"error"})
        ElMessage({message:err.message,type:"error"})
      })
    }
  }
}
</script>

<style scoped>

</style>