import {apiGen} from "./service.js";

const url = '/order/customer/order'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
    add: `post ${url}`,
    pay: `post ${url}/:id/payment`,
    receipt: `post ${url}/:id/reception`
}

export default apiGen(api)


