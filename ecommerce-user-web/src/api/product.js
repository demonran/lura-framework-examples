import {apiGen} from "./service.js";

const url = '/product/product'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
}

export default apiGen(api)


