<template>
<el-table :data="contents.filter(
        (data) =>
          !search || data.clubName.toLowerCase().includes(search.toLowerCase())
      )">
  <el-table-column prop="clubName" label="社团名称"/>
  <el-table-column label="申请人" >
    <template #default="scope">
      <span class="link" v-on:click="click(scope.row.presidentId)">点击查看</span>
    </template>
  </el-table-column>
  <el-table-column prop="slogan" label="社团口号"/>
  <el-table-column prop="introduction" label="社团简介"/>
  <el-table-column>
    <template #header>
      <el-input v-model="search" size="mini" placeholder="搜索社团" />
    </template>
    <template #default="scope">
      <el-button size="mini" @click="handleEdit(scope.row.clubId)"
      >通过</el-button
      >
      <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row.clubId)"
      >驳回</el-button
      >
    </template>
  </el-table-column>
</el-table>
</template>

<script>

import {ElMessage} from "element-plus";
import Api from "../../api/api";
import axios from "axios";

export default {
  name: "clubApprove",
  data(){
    return{
        search: "",
      contents:[]
    }
  },
  created() {
    if (!Api.check_login()) {
      this.$router.push("login")
    }
    Api.getLoginInfo().then((data)=>{
      if (data.permit !== 3){
        this.$router.push("home")
        ElMessage.error("你未拥有管理员权限")
      }
    })

    Api.queryByState(0).then((data)=>{
      this.contents = data
    })


  },
  methods:{
    click:function (id) {
      this.$router.push({name:"user",query:{id:id}})
    },
    handleEdit:function (id) {
      console.log(id)
      axios.put(Api.base+Api.club.update,{clubId:id,state:1},{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}}).then(()=>{
        Api.queryByState(0).then((data)=>{
          this.contents = data
        })
      })
    },
    handleDelete:function (id) {
      console.log(id)
      console.log(id)
      axios.put(Api.base+Api.club.update,{clubId:id,state:3},{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}}).then(()=>{
        Api.queryByState(0).then((data)=>{
          this.contents = data
        })
      })
    }
  }
}
</script>

<style scoped>
.link:hover{
  color: blueviolet;
}
.link{
  text-decoration: underline;
  color: #409eff;
}
</style>