<template>
  <section class="me">
	   <section>
  		<mt-cell title="我的资料" is-link value="" @click.native="showMyDetail"></mt-cell>
  		<mt-cell title="我的收藏"  is-link value="" @click.native="showMyCarts"></mt-cell>
  		<mt-cell title="我的订单"  is-link value="" @click.native="showMyOrders"></mt-cell>
  		<mt-cell title="我的关注的需求"  is-link value="" @click.native="showMyDemands"></mt-cell>
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
        <mt-popup  v-model="OrderVisible" position="center">
          <table>
              <tr>
                <th>订单号</th>
                <th>商品名</th>
                <th>总额</th>
                <th>操作</th>
              </tr>
            <tr  v-for='order in orders'>
              <router-link :to="{ name: 'detail', params: { id: order.goods.id }}">
                <td>{{order.id}}</td>
                <td>{{order.goods.goodsName}}</td>
                <td>总额{{order.total}}元</td>
               </router-link>
              <td><mt-button @click.native="ClickComment(order.id,order.goods.id)"size="small" type = "primary">请评论</mt-button></td>
            </tr>
            </table>
        </mt-popup>
        <mt-popup  v-model="CartVisible" position="center">
            <mt-cell  v-for='cart in carts'>
              <router-link :to="{ name: 'detail', params: { id: cart.goods.id }}">
              {{cart.id}}
              {{cart.goods.goodsName}}
              {{cart.goods.goodsIntro}}
                
              </router-link>
            </mt-cell>
        </mt-popup>
        <mt-popup  v-model="CommentVisible" position="center">
           <el-form :model="commentForm" label-width="80px" ref="editForm">
            <mt-field label="评论" placeholder="请评论" type="textarea" rows="4" v-model="commentForm.content"></mt-field>
            <el-button type="default" @click.native="CommentVisible=false">取消</el-button>
            <el-button type="primary" @click.native="addComment">提交</el-button>
            </el-form>
        </mt-popup>
     </section>
	</section>

</template>

<script>
import {addUser,getUser,userLogin,getMyOrder,getMyCart,addComment,getOrderComment} from '../../services/api/api'
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
      	loginVisible: true,
      	CartVisible: false,
      	carts:[],
      	OrderVisible: false,
      	orders: [],
      	CommentVisible:false,
      	commentForm:{
      	  order:{id:''},
      	  user:{id :''},
      	  goods:{id :''},
      	  content:'',
      	  createDate:(new Date()).toLocaleDateString()
      	},
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
				ordersize:20,
				orderpage:0,
				cartsize:20,
				cartpage:0,
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
      ClickComment:function(order,goods){
        this.commentForm.order.id = order;
        this.commentForm.goods.id = goods;
        this.CommentVisible =true;
         let params = {
          order: this.commentForm.order,
        };
       getOrderComment(params).then(res=>{
          let data = res.data.data;
          if(data!=null){
            this.commentForm.content =data.content;
          }
        });
      },
      addComment:function(){
        let params = {
          user:{id :this.$store.state.user.id},
          order: this.commentForm.order,
          goods: this.commentForm.goods,
          content: this.commentForm.content,
          createDate:this.commentForm.createDate
        };
      getOrderComment(params).then(res=>{
          let data = res.data.data;
          if(data!=null){
              MessageBox.alert("此单已评论", "操作失败");
              return false;
          }else{
            addComment(params).then(res=>{
              this.CommentVisible = false;
            });
          }
        });
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
      getCart:function(){
        let params = {
           id :this.$store.state.user.id
        };
        getMyCart(params).then(res=>{
          console.log(res.data);
          this.carts = res.data.data;
        })
      },
      getOrder:function(){
        let params = {
             id :this.$store.state.user.id
        };
        getMyOrder(params).then(res=>{
            this.orders = res.data.data;
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
      showMyCarts:function(){
         if(this.islogin){
          this.CartVisible = true;
          this.getCart();
        }else{
          this.loginVisible = true;
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
