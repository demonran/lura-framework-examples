import {apiGen} from "./service.js";

const url = '/auth/business'
const api = {
    login: `post ${url}/login`
}

export default apiGen(api)
