module.exports = {
    proxyTable: {
        '/user': {  //使用"/api"来代替"http://baidu.com"
            target: 'http://127.0.0.1:8080', //源地址
                changeOrigin: true, //改变源
        },
        pathRewrite: {
            '^/user': ''
        }
    }
}