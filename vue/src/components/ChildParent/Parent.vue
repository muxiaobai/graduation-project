<template>
  
  <div class="index">
  <h1>parent</h1>
  <input type="text" name="" v-model="parMsg"/>
  <p>{{parMsg}}</p>
  <MyChild :pushMsg='parMsg'></MyChild>
  <PushChild @dataToParent="getData"></PushChild>
  <p>getData:{{childmsg}}</p>
  </div>
  
</template>

<script>
import MyChild from './Child'
import PushChild from './PushChild'
export default {
  name: 'index',
  data: function() {
    return {
      childmsg:'',
      parMsg:''
    }
  },
  components:{
    MyChild,
    PushChild
  },
//  props: ['parMsg'] ,
  methods: {
    getData: function(val){
      this.childmsg=val;
    }
  },
  watch:{
    parMsg:function(val,oldVal){
      console.log(val+":"+oldVal);
    }
  },
  created: function(){
    console.log(this);
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
