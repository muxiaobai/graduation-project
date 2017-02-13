import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Main from 'components/Main'
import Goods from 'components/showgoods/Goods'
import GoodsList from 'components/showgoods/GoodsList'
import Login from 'components/login/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/main',
      name: 'main',
      component: Main
    },
    {
      path: '/showgoods/:id',
      name: 'goods',
      component: Goods
    
    },
    {
      path: '/goodslist',
      name: 'goodslist',
      component: GoodsList
    },
    {
      path: '/login',
      name: 'login',
      component:Login
    },
    {
      path: '/services/api/',
      name: '',
      
    }
  ]
})
