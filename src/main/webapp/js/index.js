function create_club() {
    $("#iframe").attr("src","./page/form.html")
}
function club_show() {
    $("#iframe").attr("src","./page/club_show.html")
}

function suggest_submit() {
    $("#iframe").attr("src","./page/suggest.html")

}

function my_club() {
    $("#iframe").attr("src","./page/my_club.html")

}

function login_out() {
    $.ajax({
        type:"post",
        url:"/logout",
        success:function (resp){
            console.log("退出登录成功")
            window.location = "/login.html"
        }
    })
}
function check_login() {
    axios.post('/get_current_uid',{
        
    }).then(function (response) {


        if(isNaN(response.data)){
            window.location = "/login.html"
        }else {
            $.ajax({
                type:"post",
                url:"/get_user",
                data:{"uid":response.data},
                success:function (resp){
                    console.log(resp.name)
                    document.getElementById("user").innerText = resp.name
                }
            })
        }
    }).catch(function(err){
        window.location = "/login.html"
    })
}