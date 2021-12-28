import request from "../utils/request.js";

export function register(data) {
    return request({
        url: '/auth/register',
        method: 'post',
        data
    })
}
