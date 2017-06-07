import axios from 'axios';

let base = 'http://8188025b.ngrok.io/rest';

//export const requestLogin = params => { return axios.post(`${base}/login`, params).then(res => res.data); };
export const requestLogin = params => { return axios.post(`${base}/users/adminlogin`, params);};

export const getUserList = params => { return axios.get(`${base}/user/list`, { params: params }); };

//User

export const addUser = params => { return axios.post(`${base}/users/add`, params); };
export const userLogin = params => { return axios.post(`${base}/users/login`, params);};
export const isSign = params => { return axios.get(`${base}/users/username`, params);};


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
export const getMyOrder = params => { return axios.get(`${base}/orders/mylist/`+params.id, params);};

//Preferential 优惠活动
export const getPreferentialList = params => { return axios.get(`${base}/preferentials/list`, params);};

//购物车
export const addCart = params => { return axios.post(`${base}/carts/add`, params);};
export const editCart = params => { return axios.put(`${base}/carts/`+params.id, params);};
export const getCartOne = params => { return axios.post(`${base}/carts`, params);};//根据用户和商品判断是否购物车中是否有此商品
export const getCart = params => { return axios.get(`${base}/carts/`+params.id, params);};
export const getCartListPage = params => { return axios.get(`${base}/carts/list`, params);};
export const getMyCart = params => { return axios.get(`${base}/carts/mylist/`+params.id, params);};
//评论
export const addComment = params => { return axios.post(`${base}/comments/add`, params);};
export const getGoodsComment = params => { return axios.post(`${base}/comments/goodscomment`, params);};//根据商品选择所有的评论
export const getOrderComment = params =>{return axios.post(`${base}/comments/ordercomment`,params);};
//export const getCart = params => { return axios.get(`${base}/carts/`+params.id, params);};
//export const getCartListPage = params => { return axios.get(`${base}/carts/list`, params);};
//export const getMyCart = params => { return axios.get(`${base}/carts/mylist/`+params.id, params);};

