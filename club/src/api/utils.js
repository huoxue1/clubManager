module.exports = {
    fileToBase64: function (file,callback) {
        let reader = new FileReader();
        // 传入一个参数对象即可得到基于该参数对象的文本内容
        reader.readAsDataURL(file);
        reader.onload = function (e) {
            // target.result 该属性表示目标对象的DataURL
            callback(e.target.result)
        };
    },
    format_time: function formatTimestamp( timestamp ) {
    let dateObj = new Date( timestamp *1000);

    let year = dateObj.getYear() + 1900;
    let month = dateObj.getMonth() + 1;
    let theDate = dateObj.getDate();
    let hour = dateObj.getHours();
    let a = (text)=>{
        if (text<10){
            return "0"+text
        }else {
            return text
        }
    }
    let minute = dateObj.getMinutes();
    let second = dateObj.getSeconds();
    hour = a(hour)
    minute = a(minute)
    second = a(second)
    return year +"-"+ month +"-" + theDate + " "+ hour +":"+ minute +":"+ second;
}
}