import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Main from 'components/Main'
import Goods from 'components/showgoods/Goods'
import GoodsList from 'components/showgoods/GoodsList'
import Login from 'components/login/Login'
import GoodsEdit from 'components/showgoods/GoodsEdit'
import Test from 'components/Test'
import Temp from 'components/Temp'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
      hidden: true
    },
    {
      path: '/main',
      name: 'main',
      component: Main,
      hidden: true
    },
    {
      path: '/showgoods/:id',
      name: 'goods',
      component: Goods,
      hidden: true
    },
    {
      path: '/',
      name: '商品管理',
      component: Main,
      iconCls: "el-icon-menu",
      children: [
        {path:'goodslist',name:'商品列表',component:GoodsList},
        {path:'hello',name: 'Hello',component:Hello},
        {path:'temp',name: '模板',component:Temp}
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
    {
      path: '/services/api/',
      name: '',
      hidden:true
    }
  ]
})
