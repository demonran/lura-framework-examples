import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import(/* webpackChunkName: "login" */ '/@/pages/login.vue')
    },

    {
        path: '/',
        name: 'home',
        component: () => import(/* webpackChunkName: "login" */ '/@/pages/home.vue')
    },
]

export default createRouter({
    history: createWebHashHistory(),
    routes: routes
})
