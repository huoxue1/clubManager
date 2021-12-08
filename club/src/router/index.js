import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    // {
    //   path: '/',
    //   name: 'Home',
    //   component: Home
    // },
    // {
    //   path: '/about',
    //   name: 'About',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    // }
    {
        path: '/register',
        name: 'Register',
        component: () => import("../views/Register")
    }, {
        path: "/login",
        name: "Login",
        component: () => import("../views/Login")
    }, {
        path: "/create_club",
        name: "CreatCLub",
        component: ()=>import("../views/CreateClub")
    },{
        path: "/home",
        name: "Home",
        component: ()=>import("../views/Home")
    },{
        path: "/upload_user",
        name: "UploadUser",
        component: ()=>import("../views/UploadUser")
    },{
        path: "/user",
        name: "user",
        component: ()=>import("../components/user")
    },{
        path: "/club_approve",
        name: "club_approve",
        component: ()=>import("../components/manager/clubApprove")
    },{
        path: "/joined_clubs",
        name: "joined_clubs",
        component: ()=>import("../views/JoinedClubs")
    },{
        path: "/manager_clubs",
        name: "manager_clubs",
        component: ()=>import("../views/ManagerClubs")
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

export default router
