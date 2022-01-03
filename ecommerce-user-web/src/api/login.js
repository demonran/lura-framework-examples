import request from "../utils/request.js";

export function login(data) {
    return request({
        url: '/auth/customer/login',
        method: 'post',
        data
    })
}
