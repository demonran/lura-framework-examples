import request from "../../utils/request.js";

export function list() {
    return request({
        url: '/product',
        method: 'get'
    })
}
