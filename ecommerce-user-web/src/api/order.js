import {apiGen} from "./service.js";

const url = '/order/order'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
    add: `post ${url}`
}

export default apiGen(api)


