import fetch from './http'

export const login = data => fetch('/user/login', data)
export const logout = data => fetch('/user/logout', data)
export const notoken = () => fetch('/user/notoken')
export const havetoken = () => fetch('/user/token')
