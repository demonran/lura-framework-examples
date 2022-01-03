import axios from 'axios'
import {ElNotification} from 'element-plus'
import { cloneDeep, isEmpty } from 'lodash'
import { parse, compile }  from "path-to-regexp"
// 创建axios实例

axios.defaults.baseURL = '/api'
axios.defaults.timeout = 30000


export default axios

export  function request(options, service) {
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
    if (method === 'get ') {
        options.params = cloneData;
    }
    options.method = method
    console.log(options)
    return service(options)

}



const gen = (params, service) => {
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
        }, service)
    }
}

export function apiGenerate(api, service) {
    const APIFunction = {}
    for (const key in api) {
        APIFunction[key] = gen(api[key], service)
    }
    return APIFunction
}

