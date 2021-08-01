function create_club() {
    $("#iframe").attr("src","./page/form.html")
}
function club_show() {
    $("#iframe").attr("src","./page/club_show.html")
}

function suggest_submit() {
    $("#iframe").attr("src","./page/suggest.html")

}

function check_login() {
    axios.post('/get_current_uid',{
        
    }).then(function (response) {


        if(isNaN(response.data)){
            window.location = "/login.html"
        }
    }).catch(function(err){
        window.location = "/login.html"
    })
}