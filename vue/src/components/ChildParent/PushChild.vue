<template>
  
  <div class="pushData">
  <h1>pushchild</h1>
  <input type="text" name="" v-model="childData" @change="setData"/>
  <p>pushData:{{childData}}</p>
  </div>
</template>

<script>
export default {
  name: 'index',
  data: function() {
    return {
      childData: ''
    }
  },
  methods: {
    setData: function(){
      console.log(this.childData)
      this.$emit("dataToParent",this.childData);
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
