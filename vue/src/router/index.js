import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Welcome from 'components/Welcome'
import Goods from 'components/showgoods/Goods'
import GoodsList from 'components/showgoods/GoodsList'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/welcome',
      name: 'welcome',
      component: Welcome
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
      path: '/services/api/',
      name: '',
      
    }
  ]
})
