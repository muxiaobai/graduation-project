<template>
  
  <div class="Child">
  <h1>getChild</h1>
  <p>getData:{{pushMsg}}</p>
  </div>
</template>

<script>
export default {
  name: 'Child',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'

    }
  },
  props: ['pushMsg'] 
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
