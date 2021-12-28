import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import(/* webpackChunkName: "login" */ '@/pages/login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: () => import(/* webpackChunkName: "login" */ '@/pages/register.vue')
    },

    {
        path: '/',
        name: 'home',
        component: () => import(/* webpackChunkName: "login" */ '@/pages/home.vue')
    },

    {
        path: '/shop',
        name: 'Shop',
        component: () => import('@/layout/shop/shop-layout.vue'),
        children: [{
            path: 'login',
            name: 'ShopLogin',
            component: () => import('@/pages/shop/login.vue'),
        },{
            path: 'product',
            name: 'ShopProduct',
            component: () => import('@/pages/shop/product/index.vue'),
        },
        ]
    },
]

export default createRouter({
    history: createWebHashHistory(),
    routes: routes
})
