<template>
 <div id="app" :style="{height: '100%'}">
    <div class="main" :style="{height: '100%'}">
      <router-view keep-alive = "false"></router-view>
    </div>
     <footer-nav :showNav="showNav"></footer-nav>
  </div>
</template>

<script>
import footerNav from './components/include/footerNav'
export default {
  name: 'app',
  data () {
    return {
      direction: 'forward',
      showNav: true
    }
  },
  components: {
    footerNav
  },
  watch: {
     // 如果路由有变化，会执行该方法
    '$route': function() {
      this.routeChange();
    }
  },
  methods: {
    routeChange:function() {
      console.log("route已经改变");
      let path = this.$route.path;
    //  console.log(path);
      if (path === '/main' || path === '/login' || path === '/goodslist' || path == '/userlist'|| path == '/orderlist') {
        this.showNav = false
      } else {
        this.showNav = true
      }
    }
  },
  created () {
    this.routeChange()
  }
}
</script>

<style>
#app {
	position: absolute;
	top: 0px;
	bottom: 0px;
	width: 100%;
}
  body {
    background: #f5f5f5;
  }
</style>
