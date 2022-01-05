export function getToken() {
    const userInfo = localStorage.getItem("userInfo")
    return userInfo && JSON.parse(userInfo).token
}

export function getUser() {
    const userInfo = localStorage.getItem("userInfo")
    return userInfo && JSON.parse(userInfo).user
}

export function isLogin() {
    return localStorage.getItem("userInfo") !== null
}

export function setUserInfo(userInfo) {
    localStorage.setItem("userInfo", JSON.stringify(userInfo))
}

export function removeUserInfo() {
    localStorage.removeItem("userInfo")
}
