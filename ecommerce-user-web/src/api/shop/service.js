import {apiGenerate} from "../../utils/request.js";
import axios from "axios";
import {ElNotification} from "element-plus";
import router from "../../router/index.js";

const service = axios.create({
    baseURL: '/api',
    timeout: 30000
})

service.interceptors.request.use(
    config => {
        if (getToken()) {
            config.headers["Authorization"] = getToken()
        }
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

service.interceptors.response.use(response => {
    return response.data
}, error => {
    let code = error.response.data.status
    if (code === 401) {
        return router.push(`/shop/login`)
    }else {
        ElNotification.error({
            title: '系统异常，请联系管理员',
            duration: 5000
        });
    }


    return Promise.reject(error)
})


function getToken() {
    return localStorage.getItem("shopToken")
}

export function apiGen(api) {
    return apiGenerate(api, service)
}
