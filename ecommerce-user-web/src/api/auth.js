import {apiGen} from "./service.js";

const url = '/auth/customer'
const api = {
    login: `post ${url}/login`,
    register: `post ${url}/register`
}

export default apiGen(api)
