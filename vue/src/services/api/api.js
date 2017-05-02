import axios from 'axios';

let base = 'http://b85db841.ngrok.io/rest';

export const requestLogin = params => { return axios.post(`${base}/login`, params).then(res => res.data); };

export const getUserList = params => { return axios.get(`${base}/user/list`, { params: params }); };

export const getUserListPage = params => { return axios.get(`${base}/user/listpage`, { params: params }); };

export const removeUser = params => { return axios.get(`${base}/user/remove`, { params: params }); };

export const editUser = params => { return axios.get(`${base}/user/edit`, { params: params }); };

export const addUser = params => { return axios.post(`${base}/users/addUser`, params); };
//前台增加用户使用myself
export const getTest = params => { return axios.get(`${base}/users`, { params: params }); };