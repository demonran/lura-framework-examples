import {apiGen} from "./service.js";

const url = '/order/customer/order'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
    add: `post ${url}`,
    pay: `post ${url}/:id/payment`
}

export default apiGen(api)


