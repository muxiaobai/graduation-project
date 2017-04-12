# vue

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For detailed explanation on how things work, checkout the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

前端
https://github.com/taylorchen709/vueAdmin 后台element
https://github.com/canfoo/vue2.0-taopiaopiao 前台mini-ui



数据方面:

使用mock模拟ajax的数据请求，采用axios参看 调用端:compoonents/login/Login.vue,模拟延时Promise:services/mock/mock.js, 数据:services/db/user.js

页面方面:

使用饿了么Element组件编写页面，vue-router 管理框架的页面跳转,单个center中的vue支持增删改查。

前台使用mini-ui主要是为了手机访问.


