<template>
  
  <section>
    
  </section>
</template>

<script>
import {getUser} from '../../services/api/api'
export default {
  name: 'mateiral',
  data () {
    return {
      msg: '',
    
      user:{
        username :'',
        addr:''
      }
    }
  },
  methods:{
    getDetail:function(){
      let params ={id : this.$store.state.user.id};
      console.log(params);
      getUser(params).then(res=>{
        console.log(res.data);
      })
      this.user ;
    }
  },
  created: function(){
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
