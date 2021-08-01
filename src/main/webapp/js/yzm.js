function getYzm(n) {
    switch (n) {
        case "10":{
            return "A";
        }
        case "11":{
            return "B";
        }
        case "12":{
            return "C";
        }
        case "13":{
            return "D";
        }
        case "14":{
            return "E";
        }
        case "15":{
            return "F";
        }
        case "16":{
            return "G";
        }
        case "17":{
            return "H";
        }
        case "18":{
            return "I";
        }
        case "19":{
            return "J";
        }
        case "20":{
            return "K";
        }
        case "21":{
            return "L";
        }
        case "22":{
            return "M";
        }
        case "23":{
            return "N";
        }
        case "24":{
            return "O";
        }
        case "25":{
            return "P";
        }
        case "26":{
            return "Q";
        }
        case "27":{
            return "R";
        }
        case "28":{
            return "S";
        }
        case "29":{
            return "T";
        }
        case "30":{
            return "U";
        }
        case "31":{
            return "V";
        }
        case "32":{
            return "W";
        }
        case "33":{
            return "X";
        }
        case "34":{
            return "Y";
        }
        case "35":{
            return "Z";
        }
        case "36":{
            return "a";
        }
        case "37":{
            return "b";
        }
        case "38":{
            return "c";
        }
        case "39":{
            return "d";
        }
        case "40":{
            return "e";
        }
        case "41":{
            return "f";
        }
        case "42":{
            return "g";
        }
        case "43":{
            return "h";
        }
        case "44":{
            return "i";
        }
        case "45":{
            return "j";
        }
        case "46":{
            return "k";
        }
        case "47":{
            return "l";
        }
        case "48":{
            return "m";
        }
        case "49":{
            return "n";
        }
        case "50":{
            return "o";
        }
        case "51":{
            return "p";
        }
        case "52":{
            return "q";
        }
        case "53":{
            return "r";
        }
        case "54":{
            return "s";
        }
        case "55":{
            return "t";
        }
        case "56":{
            return "u";
        }
        case "57":{
            return "v";
        }
        case "58":{
            return "w";
        }
        case "59":{
            return "x";
        }
        case "60":{
            return "y";
        }
        case "61":{
            return "z";
        }
    }
}
function randomColor() {
    var colorValue = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f";
    var colorArray = colorValue.split(",");
    var color = "#";
    for (var i = 0; i < 6; i++) {
        color += colorArray[Math.floor(Math.random() * 16)];
    }
    return color;
}
function getRandomList(){
    var arr = []
    for (var i = 0; i < 4; i++) {
        temp = parseInt(Math.random()*51)
        console.log(temp)
        if (temp<9){
            arr[i] = temp+""
        }else {
            arr[i] = getYzm(temp+"")
        }
    }
    return arr
}
function getRandomNum(n) {
    return parseInt(Math.random()*n)
}
function getVerification() {
    var ctx = document.getElementById("canvas").getContext("2d");
    ctx.clearRect(0,0, 400, 400);
    // 设置字体
    ctx.font = "128px bold 黑体";
    // 设置垂直对齐方式
    ctx.textBaseline = "top";
    // 设置颜色
    ctx.fillStyle = randomColor();
    // 绘制文字（参数：要写的字，x坐标，y坐标）
    var arr = getRandomList()
    window.arr = arr

    ctx.fillText(arr[0], 0, getRandomNum(50));
    ctx.fillStyle = randomColor();
    ctx.fillText(arr[1], 70, getRandomNum(50));
    ctx.fillStyle = randomColor();
    ctx.fillText(arr[2], 140, getRandomNum(50));
    ctx.fillStyle = randomColor();
    ctx.fillText(arr[3], 210, getRandomNum(50));
}
