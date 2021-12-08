module.exports = {
    // 配置网页的路径
  publicPath: '',
    // 配置生成的html名字
  indexPath: 'home.html',
  chainWebpack: config => {
    config
        .plugin('html')
        .tap(args => {
            // 配置前端title
          args[0].title= 'club-manager'
          return args
        })
  },

}