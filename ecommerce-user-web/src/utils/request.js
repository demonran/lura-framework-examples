import axios from 'axios'
import {ElNotification} from 'element-plus'
import { cloneDeep, isEmpty } from 'lodash'
import { parse, compile }  from "path-to-regexp"
// 创建axios实例

const service = axios.create({
    baseURL: '/', // api 的 base_url
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

export  function request(options) {
    let { data, url, method = 'get' } = options
    const cloneData = cloneDeep(data)

    try {
        const match = parse(url)
        url = compile(url)(data)

        for (const item of match) {
            if (item instanceof Object && item.name in cloneData) {
                delete cloneData[item.name]
            }
        }
    } catch (e) {
        console.log(e)
    }

    options.url = url
    options.params = cloneData
    options.method = method
    console.log(options)
    return service(options)

}



const gen = params => {
    let url = params
    let method = 'get'

    const paramsArray = params.split(' ')
    if (paramsArray.length === 2) {
        method = paramsArray[0]
        url = paramsArray[1]
    }

    return function(data) {
        return request({
            url,
            method,
            data
        })
    }
}

const apiGen = (api) => {
    const APIFunction = {}
    for (const key in api) {
        APIFunction[key] = gen(api[key])
    }
    return APIFunction
}
export default apiGen

