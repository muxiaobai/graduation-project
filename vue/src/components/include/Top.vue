<template>
<div class="top">
  <el-row>
    	<el-col :span="20" class="top-left">
  			<el-col :span="20" style="font-size:26px;">
  				<router-link :to="{ name: 'main' }">
				  <img src="../../assets/img/logo4.png" class="logo"> 
				  <span>AD<i style="color:#20a0ff">MIN</i></span>
				  </router-link>
  			</el-col>
  			
  			<el-col :span="4" class="top-right">
  				<el-dropdown trigger="click">
  					<span class="el-dropdown-link" style="color:#c0ccda;cursor: pointer;">
  					<img src="../../assets/img/user.png" class="head"> {{sysUserName}} </span>
  					<el-dropdown-menu slot="dropdown">
  						<el-dropdown-item>我的消息</el-dropdown-item>
  						<el-dropdown-item>设置</el-dropdown-item>
  						<el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
  					</el-dropdown-menu>
  				</el-dropdown>
  			</el-col>
  		</el-col>
  </el-row>
</div>
</template>

<script>
export default {
  data: function() {
    return {
      sysUserAvatar: '../../assets/img/user.png',
      sysUserName: ''
    }
  },
  methods: {
		//退出登录
		logout: function () {
			var _this = this;
			this.$confirm('确认退出吗?', '提示', {
				//type: 'warning'
			}).then(() => {
				sessionStorage.removeItem('user');
				_this.$router.push('/login');
			}).catch(() => {

			});


		}
  }
}

</script>
<style scoped>
	.logout {
		background: url(/assets/img/logout_36.png);
		background-size: contain;
		width: 20px;
		height: 20px;
		float: left;
	}
	
	.main-top {
		height: 60px;
		line-height: 60px;
		background: #1F2D3D;
		color: #c0ccda;
	}
	
	.top-right {
		text-align: right;
		padding-right: 35px;
	}
	
	.top-right .head {
		width: 40px;
		height: 40px;
		border-radius: 20px;
		margin: 10px 0px 10px 10px;
		float: right;
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
	
body {
	/*background-color: #324057;*/
	margin: 0px;
	padding: 0px;
	/*background: url(assets/bg1.jpg) center !important;
	background-size: cover;*/
	background: #1F2D3D;
	font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;
	/*font-weight: 400;*/
	font-size:14px;
	-webkit-font-smoothing: antialiased;
}	
</style>

