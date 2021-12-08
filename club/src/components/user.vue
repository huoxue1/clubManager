<template>
<div>
  <el-row align="center" style="padding-left: 40%">
    <img style="border: 4px solid salmon;margin-bottom: 30px" :src="url" width="100" height="100" />
  </el-row>
  <el-form ref="form" :model="form" label-width="120px">
    <el-form-item label="姓名：">
      <el-input v-model="user.name" placeholder="请输入你的姓名" clearable disabled/>
    </el-form-item>
    <el-form-item label="账号：">
      <el-input v-model="user.account" placeholder="请输入你的账号" clearable disabled/>
    </el-form-item>
    <el-form-item label="电话：">
      <el-input v-model="user.phone" placeholder="请输入你的电话号码" clearable disabled/>
    </el-form-item>
    <el-form-item label="邮箱：">
      <el-input v-model="user.email" placeholder="请输入你的常用邮箱" clearable disabled/>
    </el-form-item>
    <el-form-item label="班级：">
      <el-input  v-model="user.grade"  placeholder="请选择你的班级" disabled clearable>
      </el-input>
    </el-form-item>
    <el-button type="success" v-on:click="back">返回</el-button>
  </el-form>
</div>
</template>

<script>
import Api from "../api/api";

export default {
  name: "user",
  data(){
    return{
      user:{

      },
      url:""
    }
  },
  created() {
    setTimeout(()=>{
      Api.get_avatar(this.$route.query.id).then((data)=>{
        console.log(data)
        this.url = data
      })
      console.log(this.url)
      Api.get_user(this.$route.query.id).then((data) => {
        this.user = data
      })
    },500)

  },
  methods:{
    back:function () {
      window.history.back()
    }
  }
}
</script>

<style scoped>

</style>