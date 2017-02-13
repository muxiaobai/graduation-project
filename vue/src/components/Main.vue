<template>
  <div class="hello">
    <Top></Top>
    <h1>{{ msg }}</h1>
  </div>


</template>

<script>
import Top from './include/Top'
export default {
  name: 'hello',
  components: {
     Top
  },
  data: function() {  
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}

</script>

<style scoped>

</style>
