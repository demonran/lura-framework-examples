import axios from 'axios'
import {ElNotification} from 'element-plus'
// 创建axios实例

const service = axios.create({
    baseURL:  '/', // api 的 base_url
    timeout: 30000 // 请求超时时间
})

service.interceptors.response.use(response => {
    return response.data
}, error => {
    ElNotification.error({
        title: '系统异常，请联系管理员',
        duration: 5000
    })
    return Promise.reject(error)
})

export default service
