import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
//后台
import Main from 'components/Main'
import OrderList from 'components/center/OrderList'
import GoodsList from 'components/center/GoodsList'
import UserList from 'components/center/UserList'

import Login from 'components/login/Login'
import Temp from 'components/Temp'
//前台
import Index from 'components/front/Index'
//import {OrderList,GoodsList,UserList} from 'components/center'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login,
      hidden: true
    },
    //后台
    {
      path: '/main',
      name: 'main',
      component: Main,
      hidden: true
    },
    {
      path: '/showgoods/:id',
      name: 'goods',
      component: GoodsList,
      hidden: true
    },
    {
      path: '/',
      name: '管理',
      component: Main,
      iconCls: "el-icon-menu",
      children: [
        {path:'goodslist',name:'商品管理',component:GoodsList},
        {path:'orderlist',name: '订单管理',component:OrderList},
        {path:'userlist',name: '用户管理',component:UserList}
        ]
    },
     {
      path: '/',
      name: '订单管理',
      component: Main,
      iconCls: "el-icon-menu",
      children: [
        {path:'orderlist',name: '订单列表',component:Hello},
        {path:'orderedit',name:'商品列表',component:GoodsList}
        ]
    },
    {
      path: '/',
      name: '其他管理',
      component: Main,
      iconCls: "el-icon-message",
      children: [
        {path:'/hello',name: 'Hello',component:Hello},
        {path:'/hello',name: 'Hello2',component:Hello},
        {path:'/loginchild',name: 'loginchild',component:Login},
        
        ] 
    },
    //获取 暂时不行，采用axios
    {
      path: '/services/api/',
      name: '',
      hidden:true
    },
    //下面的是前台 route
    {
      path: '/',
      name: 'index',
      component: Index,
      hidden: true
      
    },
    {
      path: '/index',
      name: 'index',
      component: Index,
      hidden: true
      
    }
  ]
})
