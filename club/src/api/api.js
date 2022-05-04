const axios = require("axios");
const utils = require("./utils")
axios.defaults.withCredentials = true;
module.exports = {

    "base": "http://127.0.0.1:8080/",
    "grade": {
        "query_all": "grade/queryAll"
    },
    "user":{
        "add": "user/register",
        "login": "user/login",
    },

    "club":{
      "add":"club",
        "update":"club"
    },
    // 获取当前登录信息
    getLoginInfo: async function () {
        let  resp = await axios.post(this.base + "user/get_login_info", {}, {
            headers: {
                'Authorization': 'Basic ' + sessionStorage.getItem("token")	//	可以是授权凭证用的参数值
            }
        })

        return resp.data

    },
    // 获取某个用户
    get_user:async function(id){
        let resp = await axios.get(this.base+"user/"+id,{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return resp.data
    },
    // 获取用户头像
    get_avatar:async  function(id){
        let resp = await axios.get(this.base+"user/get_avatar/"+id,{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return resp.data
    },
    // 检查登录状态
    check_login:()=>{
        return sessionStorage.getItem("token") !== null;
    },
    // 根据state查询社团
    queryByState:async function(state){
        let resp = await axios.post(this.base+"club/queryByState/"+state,{},{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return resp.data
    },
    // 分页获取社团
    get_clubs: async function(page,size){
        let resp = await axios.get(this.base+"club?state=1&page="+page+"&size="+size,{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        return resp.data
    },
    // 获取社团头像
    get_club_avatar:async  function(clubId){
        let resp = await axios.get(this.base+"club/get_avatar/"+clubId,{headers:{  'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return resp.data
    },
    // 加入社团
    join_club:async function(clubId){
        return await axios.post(this.base + "clubMember/", {clubId: clubId}, {headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
    },

    // 判断是否加入该社团
    is_join_club:async function(clubId){
        let data = await axios.get(this.base + "clubMember/is_join_club/"+clubId,  {headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        return data.data
    },

    // 获取我加入的社团
    get_joined_clubs: async function(){
      let info = await this.getLoginInfo();
      let data = await axios.get(this.base + "clubMember?userId=" + info.userId + "&state=1&page=0&size=200", {headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
      let data1  = await this.get_manager_clubs(info.userId)
        console.log(data1)
        for (let i = 0; i < data1.length; i++) {
            data.data.content.push(data1[i])
        }

      return data.data
    },
    // 获取一个社团
    get_club:async function(clubId){
        let response = await axios.get(this.base+"club/"+clubId,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return response.data
    },
    // 获取我管理的社团
    get_manager_clubs:async function(userId){
        let response = await axios.get(this.base+"club/query_manager_clubs/"+userId,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        return response.data
    },
    // 获取200条社团加入请求
    get_club_member_request:async function(clubId){
        let data = await axios.get(this.base + "clubMember?clubId=" + clubId+ "&state=0&page=0&size=200", {headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        return data.data
    },
    // 获取多个社团的加入请求
    get_member_request: async function(clubs,){
        let request = []
        for (let i = 0; i < clubs.length; i++) {
            let data = await this.get_club_member_request(clubs[i].clubId)
            let members = data.content
            for (let j = 0; j < members.length; j++) {
                console.log(members[j])
                let data1 = await this.get_club(members[j].clubId)
                members[j].clubName = data1.clubName
                members[j].club = data1
                let data2 = await this.get_user(members[j].userId)
                members[j].userName = data2.name
                members[j].user = data2
                request.push(members[j])
            }
        }
        return request
    },
    // 处理社团成员加入请求
    handle_member_request: async function(memberId,state){
        let resp = await axios.put(this.base+"clubMember",{id:memberId,state:state},{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        return resp.data
    },
    // 获取某个社团所有成员
    get_club_members: async function (clubId) {
        let result = []
        let data = await axios.get(this.base + "clubMember?clubId=" + clubId+ "&state=1&page=0&size=300", {headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}});
        for (let i = 0; i < data.data.content.length; i++) {
            let member = {}
            let user = await this.get_user(data.data.content[i].userId);
            member.id = data.data.content[i].id
            member.userId = user.userId
            member.userName = user.name
            result.push(member)
        }
        return result
    },
    // 创建一个活动
    create_activity:async function(activity){
        activity.endTime = activity.endTime.getTime()/1000
        activity.startTime = activity.startTime.getTime()/1000
        let resp = await axios.post(this.base+"activity",activity,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        return resp.data
    },
    // 获取一个社团的活动
    get_activity_by_club:async function (clubId){
        let data = await axios.get(this.base+"activity?clubId="+clubId+"&page=0&size=200",{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        for (let i = 0; i < data.data.content.length; i++) {
            data.data.content[i].startTime = utils.format_time(data.data.content[i].startTime)
            data.data.content[i].endTime = utils.format_time(data.data.content[i].endTime)
        }
        return data.data.content
    },
    delete_active:async function(id){
        await axios.delete(this.base+"activity?id="+id,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
        let activitys = await this.get_activity_by_club(id);
        return activitys
    },
    delete_member:async function(id){
        await axios.delete(this.base+"clubMember?id="+id,{headers: {'Authorization': 'Basic ' + sessionStorage.getItem("token")}})
    }
}