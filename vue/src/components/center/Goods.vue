<template>
  <div class="goodsdetail">
    <h1>{{ msg }}</h1>
   /showgoods/id:{{ $route.params.id }}
   <router-link :to={name:"goodslist",""}
    <router-link :to="{ name: 'goodslist'}">商品列表</router-link>
  </div>
</template>

<script>
export default {
  name: 'goodsdetail',
  data: function() {
    return {
      msg: 'Welcome to Your Vue.js App, this is Goods.vue'
    }
  },
   methods: {
    handleClick: function() {
      this.$toast('Hello world!')
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
