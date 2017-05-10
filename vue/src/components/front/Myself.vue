<template>
  <section class="me">
	   <section v-model="islogin">
  		<mt-cell  title="我的资料" is-link value="" @click.native="showMyDetail"></mt-cell>
  		<mt-cell title="我的订单" to="/no" is-link value=""></mt-cell>
  		<mt-cell title="我的其他" to="/no" is-link value=""> </mt-cell>
  		<mt-cell title="帮助中心" to="/no" is-link value=""></mt-cell>
  	</section>
  	<section v-if="islogin">
        <mt-popup  v-model="editVisible" position="right" popup-transition="popup-fade">
           <el-form :model="editForm" label-width="80px" ref="editForm">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="editForm.username"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="editForm.password"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="editForm.email"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="editForm.phone"></mt-field>
            <mt-field label="生日" placeholder="请输入生日" type="date" v-model="editForm.birthday"></mt-field>
            <mt-field label="自我介绍" placeholder="自我介绍" type="textarea" rows="4" v-model="editForm.introduction"></mt-field>
            <el-button type="default" @click.native="this.editVisible =false">取消</el-button>
            <!--<router-link to="/index">取消</router-link>-->
            <el-button type="primary" @click.native="editSubmit">{{btnEditText}}</el-button>
            </el-form>
        </mt-popup>
        <mt-popup  v-model="loginVisible" position="right">
          <el-form :model="loginForm" label-width="80px" ref="editForm">
          <mt-field label="用户名" placeholder="请输入用户名" v-model="editForm.username"></mt-field>
          <mt-field label="密码" placeholder="请输入密码" type="password" v-model="editForm.password"></mt-field>
          <el-button type="primary" @click.native="cancel">{{btnEditText}}</el-button>
          <el-button type="primary" @click.native="login">{{btnEditText}}</el-button>
          </el-form>
        </mt-popup>
     </section>
	</section>

</template>

<script>
import {addUser,getUser} from '../../services/api/api'
import { mapGetters, mapMutations } from 'vuex'
export default {
  data () {
    return {
        islogin: this.$store.state.user.login,
      	//编辑界面数据
      	loginForm:{
      	  username : '',
      	  password : ''
      	},
      	loginVisible:false,
				editForm: {
    			username: '',
          email:'',
          password:'',
          phone:'',
          birthday:'',
          introduction:''
				},
				editVisible: true,
				btnEditText: '提 交',
    }
  },
  computed: {
  	
  },
  methods:{
      ...mapMutations([
          'storeUser'
        ]),
      goIndex:function(){
          this.$route;
          
      },
      showMyDetail:function(){
        if(this.islogin){
          this.editVisible =true;
        }else{
          this.loginVisible =true;
        }
      },
      editSubmit: function(){
        let params = {
          username:	this.editForm.username,
          password: this.editForm.password,
		  	};
			  addUser(params).then(res=>{
			  this.storeUser({user:res.data.data});
        this.islogin = this.$store.state.user.login;
			  });
    },
  },
  created:function(){
     this.storeUser({user:{id:12,username:'12'}});
     this.islogin = this.$store.state.user.login;
  }
}
</script>

<style scoped>
.me{
  background-color:#fff;
}
</style>
