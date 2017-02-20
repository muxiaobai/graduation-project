import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Main from 'components/Main'
import Goods from 'components/showgoods/Goods'
import GoodsList from 'components/showgoods/GoodsList'
import Login from 'components/login/Login'
import GoodsEdit from 'components/showgoods/GoodsEdit'
import Test from 'components/Test'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello,
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
      component: GoodsList,
      iconCls: "el-icon-menu",
      children: [
        {path:'/hello',name: 'Hello',component:Hello},
        {path:'/hello',name: 'Hello2',component:Hello},
        {path:'/loginchild',name: 'loginchild',component:Login},
        {path:'/test',name:'测试',component:Test}
        ]
    },
    {
      path: '/',
      name: '其他管理',
      component: GoodsList,
      iconCls: "el-icon-message",
      children: [
        {path:'/hello',name: 'Hello',component:Hello},
        {path:'/hello',name: 'Hello2',component:Hello},
        {path:'/loginchild',name: 'loginchild',component:Login},
        
        ] 
    },
    {
      path: '/login',
      name: 'login',
      component:Login,
      hidden:true
    },
    {
      path: '/services/api/',
      name: '',
      hidden:true
    }
  ]
})
