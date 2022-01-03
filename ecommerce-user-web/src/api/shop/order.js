import {apiGen} from "./service.js";

const url = '/order/shop/order'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
    edit: `put ${url}/:id`,
    add: `post ${url}`,
    del: `delete ${url}/:id`,
}

export default apiGen(api)


