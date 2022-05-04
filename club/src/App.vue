<template>
  <el-container :style="container_style">
    <el-aside :style="aside_width">
      <div
          style="height: 5%"
          class="label_style bor"
      >
        {{label}}
      </div>
      <el-menu
          router="router"
          class="el-menu-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
         >
        <el-menu-item index="home">社团首页</el-menu-item>
        <el-menu-item index="create_club">创建社团</el-menu-item>
<!--        <el-menu-item class="menu">留言板</el-menu-item>-->
      </el-menu>

    </el-aside>
    <el-container style="padding: 0">
      <el-header :style="header_height">
        <el-menu
            router="router"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            :unique-opened="true"
        >

          <el-submenu index="my_clubs">
            <template #title>我的社团</template>
            <el-menu-item index="joined_clubs">我加入的社团</el-menu-item>
            <el-menu-item index="manager_clubs">我管理的社团</el-menu-item>
          </el-submenu>
          <el-submenu index="manager">
            <template #title>社团管理</template>
            <el-menu-item index="club_approve">社团审批</el-menu-item>
            <el-menu-item>活动审批</el-menu-item>
          </el-submenu>

          <el-submenu  index="user_manager" style="float: right;margin-right: 5%;">
            <template #title>用户管理</template>
            <el-menu-item index="upload_user" >头像上传</el-menu-item>
            <el-menu-item index="user" route="" v-on:click="toUser">个人信息</el-menu-item>
            <el-menu-item index="login">用户登录</el-menu-item>
            <el-menu-item >密码找回</el-menu-item>
            <el-menu-item index="register">用户注册</el-menu-item>
            <el-menu-item v-on:click="login_out">退出登录</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer class="bor">

      </el-footer>
    </el-container>
  </el-container>
</template>



<script>


import Api from "./api/api";


export default {

  components: {},
  data(){
    return {
      label:"社团管理系统",
      container_style :{
        margin: "0 auto",
        height : "100%",
      },
      header_height:{
        padding: 0,
        backgroundColor: "#545c64",
        height: "6%"
      },
      aside_width:{
        backgroundColor: "#545c64",
        padding: 0,
        width: "12%"
      },
    }
  },
  methods:{
      toUser :async function(){
          let data = await Api.getLoginInfo()
        console.log(data.userId)
          await this.$router.push({name: "user", query: {id: data.userId}})
      },
    login_out:function () {
      sessionStorage.removeItem("token")
      this.$router.push("/login")
    }
  },
  computed : {

  },
  created() {
    this.$router.push("login")
  }
}

</script>


<style lang="scss">

.menu{
  font-size: 30px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0 auto;

}

html,
body {
  margin: 0 auto;
  padding: 0;
  height: 100%;
}

.label_style {
  font-size: large;
  font-family: "Microsoft YaHei UI Light",serif;
  font-weight: bold;
  padding-top: 10px;
  color: #42b983;
}

#content{

  width: 100%;
  height: 100%;
}

.bor{
  border: #42b983 1px solid;
}




</style>
