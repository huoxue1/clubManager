<template>
<div>
  <el-row :gutter="50">

    <el-col
    :span="8"
    v-for="club in content.filter((v)=>{
      return true
    })"
    :key="club.clubId"
    >
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span v-text="club.clubName"></span>
          </div>
        </template>
        <div style="width: 100%;height: 100%">
          <el-avatar :size="number" :src="club.avatar" style="float: left;width: 80px;height: 80px"></el-avatar>
          <el-collapse style="float: right;width: 70%" accordion model-value="0">
              <el-collapse-item name="1" title="社团简介">
                <p v-text="club.introduction"></p>
              </el-collapse-item>
            <el-collapse-item name="2" title="社团口号">
              <p v-text="club.slogan"></p>
            </el-collapse-item>
          </el-collapse>
          <el-button :disabled="club.joined || club.presidentId === info.userId" type="info" @click="join_club(club.clubId)" style="width: 100%">加入该社团</el-button>
        </div>


      </el-card>

    </el-col>

  </el-row>
  <el-pagination
      :page-size="size"
      background
      :current-page="current_page"
      :page-sizes="[3,6,9,12,15]"
      :pager-count="total_page"
      layout="prev, pager, next,sizes"
      :total="total_elements"
      @next-click="this.current_page+1"
      @prev-click="this.current_page-1"
      @current-change="page_changed"
      @size-change="size_changed"
      :hide-on-single-page="true"
  >
  </el-pagination>
</div>
</template>

<script>
import Api from "../api/api";
import {ElMessage} from "element-plus";

export default {
  name: "Home",
  data() {
    return {
      size: 6,
      total_elements: 0,
      total_page: 0,
      content: [],
      current_page: 1,
      info:{}
    }
  },
  watch:{
    current_page(newValue,oldValue){
      console.log(newValue,oldValue)
    }
  },
  created() {
    if (!Api.check_login()) {
      this.$router.push("login")
    }
    Api.getLoginInfo().then((info)=>{
      this.info = info
    })

    Api.get_clubs(0, this.size).then((data) => {
      this.total_page = data.totalPages
      this.total_elements = data.totalElements
      this.content = data.content
      for (let i = 0; i < this.content.length; i++) {
        console.log(this.content[i].presidentId,this.info.userId)

        Api.get_club_avatar(this.content[i].clubId).then((data1) => {
          this.content[i].avatar = data1
        })
        Api.is_join_club(this.content[i].clubId).then((data1)=>{

            this.content[i].joined = data1
        })
      }

    })

  },
  methods: {
    join_club:function (clubId) {
        Api.join_club(clubId).then((data)=>{
          if ((data.status===200)&&(data.data.id!==0)){
            ElMessage({message:"加入成功",type:"success"})
            for (let i = 0; i < this.content.length; i++) {
              Api.is_join_club(this.content[i].clubId).then((data1)=>{

                this.content[i].joined = data1

              })
              Api.get_club_avatar(this.content[i].clubId).then((data1) => {
                this.content[i].avatar = data1
              })
            }
          }
        })
    },
    page_changed: function (page) {
      this.current_page=page
      Api.get_clubs(this.current_page - 1, this.size).then((data) => {

        this.content = data.content
        for (let i = 0; i < this.content.length; i++) {

          Api.is_join_club(this.content[i].clubId).then((data1)=>{

            this.content[i].joined = data1

          })
          Api.get_club_avatar(this.content[i].clubId).then((data1) => {
            this.content[i].avatar = data1
          })
        }
      })
    },
    size_changed:function (size) {
      this.size = size
      console.log(size)
      Api.get_clubs(this.current_page - 1, this.size).then((data) => {
        this.content = data.content
        for (let i = 0; i < this.content.length; i++) {
          Api.is_join_club(this.content[i].clubId).then((data1)=>{

            this.content[i].joined = data1

          })
          Api.get_club_avatar(this.content[i].clubId).then((data1) => {
            this.content[i].avatar = data1
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.el-col{
  margin-bottom: 60px;
}
</style>