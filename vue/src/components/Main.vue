<template>
<div class="main">
  <el-row>
    <Top></Top>
  </el-row>
  <el-row class="main-center">
    <el-col :span="4">
      <Menu></Menu>
    </el-col>
    <el-col :span="20">
      <Center></Center>
    </el-col>
  </el-row>
</div>

</template>

<script>
import Top from './include/Top'
import Menu from './include/Menu'
import Center from './include/Center'

export default {
  name: 'hello',
  components: {
     Top,
     Menu,
     Center
  },
  data: function() {  
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}

</script>

<style >
	.fade-enter-active,
	.fade-leave-active {
		transition: opacity .5s
	}
	
	.fade-enter,
	.fade-leave-active {
		opacity: 0
	}
	
	.main-center {
		background: #324057;
		overflow: hidden;
	}

	.admin {
		color: #c0ccda;
		text-align: center;
	}
</style>
