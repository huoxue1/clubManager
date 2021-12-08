<template>
  <div style="width: 70%;margin-left: 10%">
  <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="姓名：">
        <el-input v-model="user.name" placeholder="请输入你的姓名" clearable/>
      </el-form-item>
    <el-form-item label="账号：">
      <el-input v-model="user.account" placeholder="请输入你的账号" clearable/>
    </el-form-item>
    <el-form-item label="密码：">
      <el-input v-model="user.password" placeholder="请输入你的密码" show-password clearable/>
    </el-form-item>
    <el-form-item label="确认密码：">
      <el-input v-model="repeatPassword" placeholder="请再次输入你的密码" show-password clearable/>
    </el-form-item>
    <el-form-item label="电话：">
      <el-input v-model="user.phone" placeholder="请输入你的电话号码" clearable/>
    </el-form-item>
    <el-form-item label="邮箱：">
      <el-input v-model="user.email" placeholder="请输入你的常用邮箱" clearable/>
    </el-form-item>
    <el-form-item label="班级：">
      <el-select  v-model="user.grade" style="width: 100%;" filterable placeholder="请选择你的班级">
        <el-option
            v-for="item in grades"
            :key="item.gradeId"
            :value="item.gradeId"
            :label="item.gradeName"

        >

        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="性别">
      <el-radio-group size="medium" v-model="user.sex">
        <el-radio label="男" style="margin-left: 10px" name="sex"/>
        <el-radio label="女" style="margin-left: 10px" name="sex"/>
      </el-radio-group>

    </el-form-item>
  </el-form>
    <el-button @click="click" type="success" style="width: 20%">
        提交
    </el-button>

  </div>

</template>

<script>

import axios from "axios";
import api from "../api/api"
import {ElMessage} from "element-plus";

export default {
  name: "Register",
  data(){
    return{
      user: {
        name: "",
        account: "",
        password: "",
        phone: "",
        email: "",
        sex: "男",
        permit: 1,
        grade: 1
      },
      grades: [

      ],
      repeatPassword:""
    }
  },
  created() {
    axios.get(api.base+api.grade.query_all).then((res)=>{
      this.grades = res.data.content
    })
  },
  methods:{
    click:function () {
      console.log(this.user)
      axios.post(api.base+api.user.add,this.user).then((res)=>{
        ElMessage({message:"注册成功",type:"success"})
        console.log(res.data)
      }).catch((err)=>{
        console.log(err)
        ElMessage({message:"注册失败，可能账号已存在",type:"error"})
      })
    }
  }
}
</script>

<style scoped>

</style>