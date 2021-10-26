module.exports = {
    dest:"./docs/dist",
    base: "/clubManager/dist/",
    title: '社团管理系统',
    description: '一个用springboot+mybatis开发的社团管理系统',
    themeConfig: {
        sidebar: 'auto',
        nav: [
            {text: '主页', link: '/'},                      // 根路径
            {text: "需求分析",link: "/data/demandAnalysis"},
            {text: "数据库设计",link: "/data/sql"},
            {text: "接口文档",link: "/data/config"},
            {text: "技术依赖",link: "/data/config"},
            {text: "Github",link: "https://github.com/huoxue1/leafBot"},
            // 显示下拉列表
            {
                text: 'Languages',
                items: [
                    {text: 'Chinese', link: '/language/chinese'},
                    {text: 'Japanese', link: '/language/japanese'}
                ]
            },
        ]
    }
                }