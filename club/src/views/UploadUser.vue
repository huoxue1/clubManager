<!--用户头像上传-->
<template>
  <label>头像上传</label>
  <el-upload
      :action="action"
      list-type="picture-card"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove"
      :headers="headers"
  >
    <el-icon><plus /></el-icon>
  </el-upload>
  <el-dialog v-model="dialogVisible">
    <img width="100%" :src="dialogImageUrl" alt="" />
  </el-dialog>
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
  </el-form>
</template>

<script>
import { Plus } from '@element-plus/icons'
import Api from "../api/api";

export default {
  name: "UploadUser",
  components: {
    Plus,
  },
  data(){
    return{
      user:{

      },
      imageUrl:"",
      action:Api.base+"user/upload",
      headers :{
      'Authorization': 'Basic ' + sessionStorage.getItem("token")	//	可以是授权凭证用的参数值
    }

    }
  },
  created() {
    Api.getLoginInfo().then((data)=>{
      this.user = data
    }).catch(()=>{
      this.$router.push("/login")
    })
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 5px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar-uploader-icon svg {
  margin-top: 74px; /* (178px - 28px) / 2 - 1px */
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>