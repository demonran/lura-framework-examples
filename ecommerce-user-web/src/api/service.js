import service, {apiGenerate} from "../utils/request.js";
import axios from "axios";
import {ElNotification} from "element-plus";
import router from "../router/index.js";
import {getToken} from "../utils/user.js";


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
        return router.push(`/login`)
    }else {
        ElNotification.error({
            title: '系统异常，请联系管理员',
            duration: 5000
        });
    }


    return Promise.reject(error)
})

export function apiGen(api) {
    return apiGenerate(api, service)
}
