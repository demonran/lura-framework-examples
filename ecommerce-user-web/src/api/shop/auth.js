import {apiGen} from "../../utils/request.js";

const url = '/auth/business'
const api = {
    login: `post ${url}/login`
}

export default apiGen(api)
