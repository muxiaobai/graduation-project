<template>
  <section class="me">
	   <section>
  		<mt-cell title="我的资料" is-link value="" @click.native="showMyDetail"></mt-cell>
  		<mt-cell title="我的订单"  is-link value="" @click.native="showMyOrders"></mt-cell>
  		<mt-cell title="我的优惠" to="/no" is-link value=""> </mt-cell>
  		<mt-cell title="帮助中心" to="/no" is-link value=""></mt-cell>
  	</section>
  	<section>
        <mt-popup  v-model="editVisible" position="center" popup-transition="popup-fade">
           <el-form :model="editForm" label-width="80px" ref="editForm">
            <mt-field label="用户名" placeholder="请输入用户名" v-model="editForm.username"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password" v-model="editForm.password"></mt-field>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="editForm.email"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="editForm.phone"></mt-field>
            <mt-field label="生日" placeholder="请输入生日" type="date" v-model="editForm.birthday"></mt-field>
            <mt-field label="自我介绍" placeholder="自我介绍" type="textarea" rows="4" v-model="editForm.introduction"></mt-field>
            <el-button type="default" @click.native="closeEdit">取消</el-button>
            <el-button type="primary" @click.native="editSubmit">{{btnEditText}}</el-button>
            </el-form>
        </mt-popup>
        <mt-popup  v-model="loginVisible" position="center">
          <el-form :model="loginForm" label-width="80px" ref="loginForm">
          <mt-field label="用户名" placeholder="请输入用户名" v-model="loginForm.username"></mt-field>
          <mt-field label="密码" placeholder="请输入密码" type="password" v-model="loginForm.password"></mt-field>
            <el-button type="primary" @click.native="cancel">取消</el-button>
            <el-button class='fr' type="primary" @click.native="login">{{btnEditText}}</el-button>
          </el-form>
        </mt-popup>
        
        
        
        
     </section>
	</section>

</template>

<script>
import {addUser,getUser,userLogin,getOrderListPage} from '../../services/api/api'
import { MessageBox } from 'mint-ui';
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
      	loginVisible:true,
				editForm: {
    			username: '',
          email:'',
          password:'',
          phone:'',
          birthday:'',
          introduction:''
				},
				editVisible: false,
				btnEditText: '提 交',
    }
  },
  computed: {
  	
  },
  watch:{
    '$store.state.user.login' :function(){
      this.islogin = this.$store.state.user.login;
      }
  },
  methods:{
      ...mapMutations([
          'storeUser'
        ]),
      goIndex:function(){
          this.$route;
          
      },
      getUser:function(){
          this.editForm.id = this.$store.state.user.id;
          let params = {
          id : this.$store.state.user.id
        }
        getUser(params).then(res=>{
          let data = res.data.data; 
          this.editForm.username = data.username;
          this.editForm.email = data.email;
          this.editForm.password = data.password;
          this.editForm.phone = data.phone;
          this.editForm.birthday = data.birthday;
          this.editForm.introduction = data.introduction;
          })
      },
      getOrder:function(){
        let params = {
             
        };
        
        getOrderListPage(params).then(res=>{
          
        });
      },
      showMyDetail:function(){
        if(this.islogin){
          this.editVisible =true;
          this.btnEditText = '修改';
          this.getUser();
        }else{
          this.loginVisible =true;
          this.btnEditText = '登录';
        }
      },
      showMyOrders: function(){
        if(this.islogin){
          this.OrderVisible =true;
          this.getOrder();
        }else{
          this.loginVisible =true;
          this.btnEditText = '登录';
        }
      },
      cancel :function(){
        this.loginVisible =false;
      },
      login : function(){
        let params = {
          username : this.loginForm.username,
          password : this.loginForm.password,
        }
        userLogin(params).then(res =>{
          let data = res.data;
          console.log(data);
          if(data.islogin){
            this.storeUser({user:res.data.data});
            this.loginVisible =false;
          }else{
            MessageBox.alert("账号密码错误", "登录失败");
          }
        });
      },
      closeEdit : function(){
        this.editVisible =false;
      },
      editSubmit: function(){
        let params = {
          username:	this.editForm.username,
          password: this.editForm.password,
		  	};
			  if(this.editForm.id == 0){
			  addUser(params).then(res=>{
			  this.storeUser({user:res.data.data});
        this.islogin = this.$store.state.user.login;
			  });
			    
			  }else{
			    
			  }
			  
			  this.loginVisible = false;
			  this.editVisible =false;
    },
  },
  created:function(){
     this.islogin = this.$store.state.user.login;
     if(this.islogin){
       this.loginVisible =false;
     }else{
       this.loginVisible =true;
       this.btnEditText = '登录';
     }
  }
}
</script>

<style scoped>
.me{
  background-color:#fff;
}
</style>
