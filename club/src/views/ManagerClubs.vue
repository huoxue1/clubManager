<template>
  <div style="width: 100%;height: 100%;">
    <el-tabs v-model="select_tab">
      <el-tab-pane name="club_info" label="社团资料管理">
        <div style="width: 60%;margin-left: 20%;margin-right: 25%;">



          <el-form ref="form" :model="form" label-width="120px">
            <el-form-item  label="选择社团：">
              <el-select v-model="select_club_id" style="width: 100%">
                  <el-option v-for="club in clubs" :label="club.clubName" :key="club.clubId" :value="club.clubId"/>
              </el-select>
            </el-form-item>
            <el-form-item label="社团名称：">
              <el-input v-model="club.clubName" placeholder="请输入你的社团名称"  clearable/>
            </el-form-item>
            <el-form-item label="社团简介：">
              <el-input
                  v-model="club.introduction"
                  type="textarea"
                  :autosize="{ minRows: 2, maxRows: 4 }"
                  size=""
                  placeholder="请输入你的社团简介"
                  clearable
              />
            </el-form-item>
            <el-form-item label="社团口号：">
              <el-input v-model="club.slogan" placeholder="请输入你的社团口号"  clearable/>
            </el-form-item>
          </el-form>
          <el-button type="success">提交修改</el-button>
        </div>


      </el-tab-pane>
      <el-tab-pane name="request" label="社团成员审核">
        <el-table :data="requests.filter(
        (data) =>
          !search || data.userName.toLowerCase().includes(search.toLowerCase()) || data.clubName.toLowerCase().includes(search.toLowerCase())

      )" :row-style="set_cell_style" style="width: 100%;margin-left: 20px;margin-right: 20px">
          <el-table-column prop="id" label="ID" align="center"/>
          <el-table-column prop="userName" label="姓名" align="center"/>
          <el-table-column prop="clubName" label="社团名" align="center"/>
          <el-table-column align="center">
            <template #header>
              <el-input v-model="search" size="mini" placeholder="Type to search"/>
            </template>
            <template #default="scope">
              <el-button size="small" @click="handleApprove(scope.row.id)"
              >同意
              </el-button
              >
              <el-button
                  size="small"
                  type="danger"
                  @click="handleRefuse(scope.row.id)"
              >拒绝
              </el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane name="club_member" label="社团成员管理">
          <span>
            <el-select placeholder="请选择社团" v-model="manager_member_club_id" style="width: 100%">
              <el-option v-for="club in clubs" :label="club.clubName" :key="club.clubId" :value="club.clubId"/>
            </el-select>
          </span>

        <el-table border="true" :data="members" :row-style="set_cell_style" style="width: 100%;">
          <el-table-column prop="userId" label="ID" align="center"/>
          <el-table-column prop="userName" label="姓名" align="center"/>

          <el-table-column  label="操作" align="center">
            <template #default="scope">
              <el-button type="success" @click="delete_member(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>


        </el-table>


      </el-tab-pane>
      <el-tab-pane name="club_activity" label="社团活动管理">
          <el-tabs tab-position="right" v-model="activity_tab">
            <el-tab-pane name="create_activity" label="活动创建">
              <el-form ref="form" :model="activity" label-width="120px">
                <el-form-item label="社团选择:">
                  <el-select v-model="activity.clubId" style="width: 100%">
                    <el-option v-for="club in clubs" :label="club.clubName" :key="club.clubId" :value="club.clubId"/>
                  </el-select>
                </el-form-item>
                <el-form-item label="活动名称:">
                  <el-input placeholder="请输入活动名称"  v-model="activity.activityName"/>
                </el-form-item>
                <el-form-item label="活动主题:">
                  <el-input placeholder="请输入活动主题"  v-model="activity.activityTheme"/>
                </el-form-item>
                <el-form-item label="活动描述:">
                  <el-input placeholder="请输入活动大概内容"  v-model="activity.activityDescription"/>
                </el-form-item>
                <el-form-item label="开始时间">
                  <el-date-picker
                      style="width: 100%"
                      v-model="activity.startTime"
                      type="datetime"
                      placeholder="Select date and time"
                  >
                  </el-date-picker>
                </el-form-item>
                <el-form-item label="结束时间">
                  <el-date-picker
                      style="width: 100%"
                      v-model="activity.endTime"
                      type="datetime"
                      placeholder="Select date and time"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-form>
              <el-button @click="create_activity" type="success">提交活动</el-button>
            </el-tab-pane>
            <el-tab-pane name="manager_activity" label="活动管理">
                <span>
                  <el-select placeholder="请选择社团" v-model="manager_activity_club_id" style="width: 100%">
                    <el-option v-for="club in clubs" :label="club.clubName" :key="club.clubId" :value="club.clubId"/>
                  </el-select>
                </span>

              <el-table border="true" :data="activitys" :row-style="set_cell_style" style="width: 100%;">
                <el-table-column prop="id" label="ID" align="center"/>
                <el-table-column prop="activityName" label="活动名称" align="center"/>
                <el-table-column prop="activityTheme" label="活动主题" align="center"/>
                <el-table-column prop="startTime" label="开始时间" align="center"/>
                <el-table-column prop="endTime" label="结束时间" align="center"/>
                <el-table-column  label="操作" align="center">
                  <template #default="scope">
                    <el-button type="success" @click="delete_active(scope.row.id)">删除</el-button>
                  </template>
                </el-table-column>

                <el-table-column type="expand">
                  <template #default="props">
                    {{props.row.activityDescription}}
                  </template>
                </el-table-column>

              </el-table>


            </el-tab-pane>

          </el-tabs>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Api from "../api/api";
import {ElMessage} from "element-plus";

export default {
  name: "ManagerCLubeds",
  data() {
    return {
      // 成员请求模块
      select_tab: "club_info",
      info: {},
      clubs: [],
      requests: [],
      search: "",

      // 用户数据模块
      form: {},
      select_club_id: 0,
      club:{},

      //活动模块
      activity:{

      },
      activity_tab: "create_activity",

      // 活动管理页面社团id
      manager_activity_club_id:"",
      activitys:[],

      // 社团成员管理
      manager_member_club_id:"",
      members:[]
    }
  },
  created() {
    if (!Api.check_login()) {
      ElMessage({message:"请登录之后再访问",type:"error"})
      this.$router.push("login")
    }
    let a = async () => {
      this.info = await Api.getLoginInfo()
      this.activity.userId = this.info.userId
      this.clubs = await Api.get_manager_clubs(this.info.userId)
      this.select_club_id = this.clubs[0].clubId
      this.club = this.clubs[0]
    }
    a()
  },
  methods: {
    handleApprove: function (id) {
      Api.handle_member_request(id, 1).then((data) => {
        console.log(data)
        this.requests = []
        Api.get_member_request(this.clubs).then(data => {
          console.log(data)
          this.requests = data
        })
      })
    },
    handleRefuse: function (id) {
      Api.handle_member_request(id, -1).then(data => {
        console.log(data)
        this.requests = []
        Api.get_member_request(this.clubs).then(data => {
          console.log(data)
          this.requests = data
        })
      })
    },
    set_cell_style: function (obj) {
      console.log(obj)
      if (obj.clumnIndex === 3) {
        return {"text-align": "left"}
      }
      return {}
    },
    create_activity:function () {
      Api.create_activity(this.activity).then(data=>{
        if (data.id!==0){
          ElMessage({message:"创建成功",type:"success"})
        }
      })
    },
    delete_active:function(id){
      Api.delete_active(id).then(data=>{
        this.activitys = data
      })
    },
    delete_member:function (id) {
      Api.delete_member(id)
      Api.get_club_members(this.manager_member_club_id).then(data=>{
        this.members = data
      })
    }
  },

  watch: {
    select_tab() {
      if (this.select_tab === "request") {
        this.requests = []
        Api.get_member_request(this.clubs).then(data => {
          console.log(data)
          this.requests = data
        })
      }
    },
    select_club_id(){
      Api.get_club(this.select_club_id).then(data=>{
        this.club = data
      })
    },
    manager_activity_club_id(){
      Api.get_activity_by_club(this.manager_activity_club_id).then(data=>{
        this.activitys = data
      })
    },
    manager_member_club_id(){
      Api.get_club_members(this.manager_member_club_id).then(data=>{
        this.members = data
      })
    }
  }
}
</script>

<style scoped>
a {

}
</style>