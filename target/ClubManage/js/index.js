function create_club() {
    $("#iframe").attr("src","./page/form.html")
}
function club_show() {
    $("#iframe").attr("src","./page/club_show.html")
}

function check_login() {
    axios.post('/get_current_uid',{
        
    }).then(function (response) {
        console.log(response)
        alert(response.code)
        if(response){
            window.location = "/login.html"
        }else{
            alert("登录失败")
        }
    }).catch(function(err){
        window.location = "/login.html"
    })
}