import axios from 'axios';

let base = 'http://09981bdd.ngrok.io/rest';

export const requestLogin = params => { return axios.post(`${base}/login`, params).then(res => res.data); };

export const getUserList = params => { return axios.get(`${base}/user/list`, { params: params }); };

//User
export const addUser = params => { return axios.post(`${base}/users/add`, params); };
//前台增加用户使用myself 后台可以借用
export const removeUser = params => { return axios.delete(`${base}/users/`+params.id, params);};
export const editUser = params => { return axios.put(`${base}/users/`+params.id,params);};
export const getUser = params => { return axios.get(`${base}/users/`+params.id, params);};
export const getUserListPage = params => { return axios.get(`${base}/users/list`,params);};


//Goods
export const addGoods = params => { return axios.post(`${base}/goods/add`, params);};
export const removeGoods = params => { return axios.delete(`${base}/goods/`+params.id, params);};
export const editGoods = params => { return axios.put(`${base}/goods/`+params.id, params);};
export const getGoods = params => { return axios.get(`${base}/goods/`+params.id, params);};
export const getGoodsListPage = params => { return axios.get(`${base}/goods/list`, params);};


//下订单
export const addOrder = params => { return axios.post(`${base}/orders/add`, params);};
export const editOrder = params => { return axios.put(`${base}/orders/`+params.id, params);};
export const getOrder = params => { return axios.get(`${base}/orders/`+params.id, params);};
export const getOrderListPage = params => { return axios.get(`${base}/orders/list`, params);};
