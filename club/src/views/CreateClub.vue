<template>
  <div style="width: 70%;margin-left: 10%">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="社团名称：">
        <el-input v-model="club.clubName" placeholder="请输入你的社团名称" @blur="lostFocus" clearable/>
      </el-form-item>
      <el-form-item label="社团简介：">
        <el-input
            v-model="club.introduction"
            type="textarea"
            :autosize="{ minRows: 2, maxRows: 4 }"
            size=""
            placeholder="请输入你的社团简介"
            @blur="lostFocus"
            clearable
        />
      </el-form-item>
      <el-form-item label="社团口号：">
        <el-input v-model="club.slogan" placeholder="请输入你的社团口号" @blur="lostFocus" clearable/>
      </el-form-item>
      <el-form-item label="社&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：">
        <el-input v-model="name" placeholder="" disabled clearable/>
      </el-form-item>
      <el-form-item label="头像上传：">
        <el-button type="success" @click="upload" style="float: left">点击上传</el-button>
        <label v-if="club.clubAvatar!==''" style="float: left;color: red">上传成功</label>
      </el-form-item>
    </el-form>
    <el-button @click="click" type="success" :disabled="disableSubmit" style="width: 20%">
      提交
    </el-button>

  </div>
</template>

<script>
import Api from "../api/api";
import Utils from "../api/utils";

import axios from "axios";
import {ElMessage} from "element-plus";

export default {
  name: "CreateClub",
  data(){
    return{
      club:{
        clubName:"",
        introduction:"",
        slogan:"",
        presidentId:0,
        clubAvatar:""
      },
      name:"",
      disableSubmit : true
    }
  },
  created() {
    if (!Api.check_login()) {
      ElMessage({message:"请登录之后再访问",type:"error"})
      this.$router.push("login")
    }
    let user = Api.getLoginInfo()
    if (user === null){
      this.$router.push("/login")
    }else{
     user.then((data)=>{
       this.club.presidentId = data.userId
       this.name = data.name
     })
    }
  },

  methods:{
    lostFocus: function () {
          if((this.club.clubName !== "")&&(this.club.slogan !== "")&&(this.club.introduction!=="")&&(this.club.clubAvatar !=="")){
            this.disableSubmit = false
          }
    },
    click: async function () {
      let resp;
      try {
        resp = await  axios.post(Api.base+Api.club.add,this.club,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
      }catch (e) {
        ElMessage({message:"提交出现错误"+e,type:"error"})
      }
      ElMessage({message:"提交成功，正在等待管理员审核...",type:"success"})
      console.log(resp.data)
    },
    upload:async function(){
      let files = await window.showOpenFilePicker({
        multiple: false,
        types: [{
          accept: {
            'image/*': ['.png', '.gif', '.jpeg', '.jpg', '.webp']
          }
        }]
      });
      let file = await files[0].getFile();
      Utils.fileToBase64(file,(base64)=>{
        this.club.clubAvatar = base64.replace("data:image/png;base64,","")
      })
    }
  }
}
</script>

<style scoped>

</style>