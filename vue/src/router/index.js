import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
//后台
import Main from 'components/Main'
import OrderList from 'components/center/OrderList'
import GoodsList from 'components/center/GoodsList'
import UserList from 'components/center/UserList'
import MessageList from 'components/center/MessageList'

import Login from 'components/login/Login'
import Temp from 'components/Temp'
//前台
import Index from 'components/front/Index'
import Hot from 'components/front/hot'
import hotEvaluation  from 'components/front/hotEvaluation'
import hotSecond from 'components/front/hotSecond'
import Myself from 'components/front/Myself'
import NoData from 'components/front/NoData'
import AgriculturalProductsDetail from 'components/front/AgriculturalProductsDetail'
import DemandDetail from 'components/front/DemandDetail'
//import {OrderList,GoodsList,UserList} from 'components/center'
import Parent from 'components/ChildParent/Parent'
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/childparent',
      name: '组件之间的数据交换',
      component: Parent,
      hidden:true
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      hidden: true
    },
     //下面的是前台 route
    {
      path: '/',
      name: 'index',
      component: Index,
      hidden: true,
      children:[
      {
        path: 'seco',
        name: 'hot',
        component: Hot
      },
      {
        path: 'first',
        name: 'first',
        component: Hot
      }
      ]
    },
    {
      path: '/index',
      name: 'index',
      component: Index,
      hidden: true,
      children:[
      {
        path: 'seco',
        name: 'hot',
        component: Hot
      },
      {
        path: 'first',
        name: 'first',
        component: Hot
      }
      ]
      
    },
    {
      path: '/hotsecond',
      name: 'hotsecond',
      component: hotSecond,
      hidden: true
      
    },
    {
      path : '/goods/detail/:id',
      name: 'detail',
      component : AgriculturalProductsDetail,
      children:[
      {
        path: '/goods/detail/:id',
        name: 'hotEvaluation',
        component: hotEvaluation
      }
      ],
      hidden : true
    },
    {
      path : '/demand/detail/:id',
      name: 'demanddetail',
      component : DemandDetail,
      children:[
      {
        path: '/goods/detail/:id',
        name: 'hotEvaluation',
        component: hotEvaluation
      }
      ],
      hidden : true
    },
    {
      path : '/me',
      name: 'me',
      component : Myself,
      hidden:true
    },
        {
      path : '/no',
      name: 'no',
      component : NoData,
      hidden:true
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
        {path:'userlist',name: '用户管理',component:UserList},
        {path:'orderlist',name: '订单管理',component:OrderList},
        ]
    },
     {
      path: '/',
      name: '发布信息管理',
      component: Main,
      iconCls: "el-icon-menu",
      children: [
        {path:'messagelist',name: '发布信息',component:MessageList},
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
    }
  ]
})
