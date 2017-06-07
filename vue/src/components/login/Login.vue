<template>
<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-position="left" label-width="0px" class="demo-ruleForm card-box loginform">
    <h3 class="title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="this.ruleForm.account" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="this.ruleForm.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox  checked style="margin:0px 0px 35px 0px;">记住密码</el-checkbox>
    <el-checkbox  v-model='capacity' style="margin:0px 0px 35px 0px;">管理员</el-checkbox>
    <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click=handleSubmit >登录</el-button>
        <!--<el-button >重置</el-button>-->
    </el-form-item>
</el-form>
</template>

<script>
import { requestLogin } from '../../services/api/api';
export default {
  data() {
    return {
      logining: false,
      ruleForm: {
        account: 'admin',
        password: '123456'
      },
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ]
      },
      checked: true,//记住密码
      capacity:false //管理员登录到后台，不是登录到前台
    };
  },
  methods: {
    handleReset2() {
      this.$refs.ruleForm.resetFields();
    },
    handleSubmit(ev) {
      var _this = this;
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          this.logining = true;
          var loginParams = { username: this.ruleForm.account, password: this.ruleForm.password };
          requestLogin(loginParams).then(data => {
            this.logining = false;
            let { msg, code, user } = data.data;
            console.log(data);
            if (code !== 200) {
              this.$notify({
                title: '错误',
                message: msg,
                type: 'error'
              });
            } else {
              sessionStorage.setItem('user', JSON.stringify(user));
              if(this.capacity){
                  this.$router.push({ path: '/main' });
              }else{
              //    this.$router.push({ path: '/index' });
                  this.$router.push({ path: '/main' });
              }
            }
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
  .card-box {
    padding: 20px;
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin-bottom: 20px;
    background-color: #F9FAFC;
    margin: 180px auto;
    width: 400px;
    border: 2px solid #8492A6;
  }
  
  .title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  
  .loginform {
    width: 350px;
    padding: 35px 35px 15px 35px;
  }
  
.bounce-enter-active {
	animation: bounce-in .5s;
}

.bounce-leave-active {
	animation: bounce-out .2s;
}

@keyframes bounce-in {
	0% {
		transform: scale(0);
	}
	50% {
		transform: scale(1.05);
	}
	100% {
		transform: scale(1);
	}
}

@keyframes bounce-out {
	0% {
		transform: scale(1);
	}
	50% {
		transform: scale(0.95);
	}
	100% {
		transform: scale(0);
	}
}
.fade-enter-active, .fade-leave-active {
	transition: opacity .5s
}
.fade-enter, .fade-leave-active {
	opacity: 0
}

.toolbar .el-form-item {
	margin-bottom: 10px;
}

.toolbar {
	background: #fff;
	padding: 10px 10px 0px 10px;
}
</style>