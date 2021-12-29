import apiGen from "../../utils/request.js";

const url = '/product'
const api = {
    list: `get ${url}`,
    get: `get ${url}/:id`,
    edit: `put ${url}/:id`,
    add: `post ${url}`,
    del: `delete ${url}/:id`,
}

export default apiGen(api)


