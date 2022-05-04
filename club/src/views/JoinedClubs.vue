<template>
<div style="width: 100%;height: 100%">
  <el-select v-model="select_club_id" aria-placeholder="你未加入社团" style="width: 100%;text-align: center">
    <el-option v-for="club in joined_clubs" :key="club.clubId" :label="club.clubName" :value="club.clubId">
    </el-option>
  </el-select>
  <div style="width: 80%;height: 97%;float:left;">
    <el-scrollbar v-if="activitys.length>0" >
      <el-card v-for="activity in activitys"  :key="activity.id" class="box-card">
        <template #header>
          <div class="card-header">
            <span><h2>{{activity.activityName}}</h2></span>
          </div>
        </template>
        <span class="span1"><div class="item">活动主题：</div>{{activity.activityTheme}}</span><br/><br/>
        <span class="span1"><div class="item">活动描述：</div>{{activity.activityDescription}}</span><br/><br/>
        <span class="span1"><div class="item">活动时间：</div>{{activity.startTime}}至{{activity.endTime}}</span>
      </el-card>
    </el-scrollbar>
    <span class="item" v-else>该社团还没有活动呢</span>
  </div>
  <div style="width: 19.7%;height: 97%;float: right;">
    <el-scrollbar>
        <ul class="list" style="height: 100%">
          <li class="list-item" style="color: #42b983;background-color: #ddd1e3" v-text="president"></li>
          <li v-for="member in members" @click="aa(member)" class="list-item" :key="member.userId" v-text="member.userName"></li>

        </ul>
    </el-scrollbar>
  </div>
</div>
</template>

<script>
import Api from "../api/api";
import {ElMessage} from "element-plus";

export default {
  name: "JoinedClubs",
  data(){
    return{
      select_club_id: 0,
      joined_clubs:[],
      president:"",
      members:[],
      activitys:[]
    }
  },
  watch:{
    select_club_id(){

      Api.get_activity_by_club(this.select_club_id).then((resp)=>{
        this.activitys = resp;
      })

      for (let i = 0; i < this.joined_clubs.length; i++) {
        if (this.joined_clubs[i].clubId === this.select_club_id){
          Api.get_user(this.joined_clubs[i].presidentId).then(data=>{
            this.president = data.name
          })
        }
      }
      Api.get_club_members(this.select_club_id).then(data=>{
        this.members = data
      })
    },

  },
  created() {
    if (!Api.check_login()) {
      ElMessage({message:"请登录之后再访问",type:"error"})

      this.$router.push("login")
    }
    Api.get_joined_clubs().then((data)=>{
      console.log(data.content[0])
      Api.get_club(data.content[0].clubId).then(resp=>{
        Api.get_user(resp.presidentId).then(d=>{
          this.president = d.name
        })
      })
      for (let i = 0; i < data.content.length; i++) {
        Api.get_club(data.content[i].clubId).then((resp)=>{
          this.joined_clubs.push(resp)
        })
      }
      this.select_club_id = data.content[0].clubId

      Api.get_activity_by_club(this.select_club_id).then((resp)=>{
        this.activitys = resp;
      })


      Api.get_club_members(this.select_club_id).then(data=>{
        this.members = data
        console.log("社团成员")
        console.log(data)
      })
    })
  },
  methods:{
    aa:function (member) {
      console.log(member)
    }
  }
}
</script>

<style scoped lang="scss">
.list {
  height: 300px;
  padding: 0;
  margin: 0;
  list-style: none;
}
.list-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: var(--el-color-primary-light-9);
  margin: 10px;
  color: var(--el-color-primary);
& + .list-item {
    margin-top: 10px;
  }

}



.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
  display: inline;
  font-size: 30px;

}
.span1{
  text-align: left;
}

.box-card{
  text-align: left;
}

.card-header{
  text-align: center;
}

</style>