<template>
<div class="main">
  <el-row>
    <Top></Top>
  </el-row>
  <el-row>
    <el-col :span="4">
      <Menu></Menu>
    </el-col>
    <el-col :span="20">
      <div class="section"></div>
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
     Top
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
	
	.main {
		position: absolute;
		top: 0px;
		bottom: 0px;
		width: 100%;
	}

	.main-center {
		background: #324057;
		position: absolute;
		top: 60px;
		bottom: 0px;
		overflow: hidden;
	}
	
	.main-c-c {
		background: #f1f2f7;
		position: absolute;
		right: 0px;
		top: 0px;
		bottom: 0px;
		left: 230px;
		overflow-y: scroll;
		padding: 20px;
	}

	.logo {
		width: 40px;
		float: left;
		margin: 10px 10px 10px 18px;
	}
	
	.tip-logout {
		float: right;
		margin-right: 20px;
		padding-top: 5px;
	}
	
	.tip-logout i {
		cursor: pointer;
	}
	
	.admin {
		color: #c0ccda;
		text-align: center;
	}
</style>
