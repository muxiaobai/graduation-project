<template>
	<section id="movie-detail">
		<header class="mbg pr">
			<figure class="d-cover" style="float:left;position:inherit;">
				<img :src="detailObj.avatar ? `${detailObj.avatar}` : 'https://gw.alicdn.com/tps/i1/TB147JCLFXXXXc1XVXXxGsw1VXX-112-168.png'" alt="">
			</figure>
			<article class="d-info"  style="float:left; margin-left:auto;">
				<p class="d-name tddd">{{ detailObj.goodsName }}</p>
				<p class="tddd">{{ detailObj.goodsName }}</p>
				<span>{{ detailObj.goodsPrice}}元/份</span><span>&nbqs;仅剩{{detailObj.goodsStock}}份</span>
				<p>{{ new Date(detailObj.goodsDate).toLocaleDateString() }}</p>
				<div class="full-star pr">
					<div class="score-start" :style="{width: `${detailObj.remark * 10}%`}"></div>
				<!--	<span class="score pa">{{ detailObj.remark }}分</span>-->
				</div>
				<mt-button :disabled = Cartdisabled type="primary" size="small" class = "buy" @click.native="handleAddCart">{{CartBtnStr}}</mt-button>
				<mt-button type="primary" size="small" class = "buy" @click.native="handleAdd">购买</mt-button>
			</article>
		</header>
	
		<section v-if="infoObj">
			<section class="intro-block border-1px-bottom">
				<article class="d-intro">
					<p ref="dint" :class="{'hide-something': hideSomething}">
						{{ detailObj.detailIntro }}
					</p>
				<img :src="detailObj.detailFile1 ? `${detailObj.detailFile1}` : 'https://gw.alicdn.com/tps/i1/TB147JCLFXXXXc1XVXXxGsw1VXX-112-168.png'" alt="">
				<img :src="detailObj.detailFile2 ? `${detailObj.detailFile2}` : 'https://gw.alicdn.com/tps/i1/TB147JCLFXXXXc1XVXXxGsw1VXX-112-168.png'" alt="">
				<img :src="detailObj.detailFile3 ? `${detailObj.detailFile2}` : 'https://gw.alicdn.com/tps/i1/TB147JCLFXXXXc1XVXXxGsw1VXX-112-168.png'" alt="">
				<img :src="detailObj.detailFile4 ? `${detailObj.detailFile4}` : 'https://gw.alicdn.com/tps/i1/TB147JCLFXXXXc1XVXXxGsw1VXX-112-168.png'" alt="">
					<p class="d-control" @click="controlShowMany">
						<span v-if="hideSomething">展开</span>
						<span v-else>收起</span>
					</p>
				</article>
			</section>
			<hotEvaluation :lists="evalLists"></hotEvaluation>
		</section>
		<section v-else class="no-data">
			<span>暂时没有更多数据～</span>
		</section>
		<mt-popup  v-model="popupVisible"  position="center" class ='popup'> 
		<mt-field label="收货人" placeholder="请输入" v-model="editForm.username"></mt-field>
		<mt-field label="地址" placeholder="收货地址" type="textarea" rows="4" v-model="editForm.addr"></mt-field>
		<mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="editForm.email"></mt-field>
		<mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="editForm.phone"></mt-field>
		<mt-field label="购买数量" placeholder="请输入数字" type="number" min ="1" v-model="editForm.number"></mt-field>
		<mt-field label="总计" type="text" v-model="editForm.total" readonly ></mt-field>
		<mt-button type="default" @click.native="popupVisible = false">取消</mt-button>
		<mt-button type="primary" class='fr'  @click.native="editSubmit">提交</mt-button>
		</mt-popup>
		<mt-popup  v-model="loginVisible" position="center" >
          <el-form :model="loginForm" label-width="80px" ref="loginForm">
          <mt-field label="用户名" placeholder="请输入用户名" v-model="loginForm.username"></mt-field>
          <mt-field label="密码" placeholder="请输入密码" type="password" v-model="loginForm.password"></mt-field>
            <el-button type="primary" @click.native="cancel">取消</el-button>
            <el-button class='' type="primary" @click.native="login">登录</el-button>
           <el-button class='fr' type="primary" @click.native="signin">注册</el-button>
          </el-form>
        </mt-popup>
	</section>
</template>

<script>
import { mapMutations } from 'vuex'
import { MessageBox } from 'mint-ui';
import { hotEvaluation } from './hotEvaluation'
import {getGoods,addOrder,addCart,userLogin,getCartOne,addUser,isSign} from '../../services/api/api'
export default{
	data () {
		return {
			islogin:this.$store.state.user.login,
				//编辑界面数据
		  	loginForm:{
		  	  username : '',
		  	  password : ''
		  	},
			loginVisible: false,
			CartBtnStr : "请加入购物车",
			Cartdisabled: false,
			hideSomething: true,
			detailObj: {},
			infoObj: false,
			evalLists: [],
			popupVisible: false,
			editForm: {
				username:'',
				addr:'',
				email:'',
				phone:'', 
				number:1,
				price: 0,
				total: 0,
			}
		}
	},
	components: {
		hotEvaluation
	},
	watch: {
		'editForm.number' : function(val){
			this.editForm.number = val;
    	    this.editForm.total = this.getTotal();
		},
	    '$store.state.user.login' :function(){
    	  this.islogin = this.$store.state.user.login;
		}
	},
	methods: {
		...mapMutations([
		  'pushLoadStack',
		  'completeLoad',
		  'storeUser'
		]),
		controlShowMany () {
			this.hideSomething = !this.hideSomething
		},
		requestData (url, fn) {
	      this.pushLoadStack()
	      this.$http.get(url).then(fn).then(this.completeLoad)
    	},
    	getTotal:function(){
    		let total = 0;
    		let origin = this.editForm.price * this.editForm.number;
    		if(this.detailObj.preferential.whichType == 1){
    			//折扣
    			total = origin * this.detailObj.preferential.discount;
    		}else if(this.detailObj.preferential.whichType == 2){
    			//减免
    			total = origin - this.detailObj.preferential.reducePrice;
    		}else{
				total = origin;
    		}
    		console.log(total);
    		return total;
    	},
    	cancel :function(){
        this.loginVisible =false;
    	},
		login : function(){
			let params = {
			  username : this.loginForm.username,
			  password : this.loginForm.password,
			};
			userLogin(params).then(res =>{
			  let data = res.data;
			  console.log(data);
			  if(data.islogin){
			    this.storeUser({user:res.data.data});
			    this.loginVisible =false;
			     MessageBox.alert("登录成功", "登录成功");
			  }else{
			    MessageBox.alert("账号密码错误", "登录失败");
			  }
			});
		},
		signin:function(){
			let params = {
			  username : this.loginForm.username,
			  password : this.loginForm.password,
			};
			addUser(params).then(res =>{
			  let data = res.data;
			  console.log(data);
			  this.storeUser({user:res.data.data});
			  this.loginVisible =false;
			  MessageBox.alert("您已注册成功", "注册成功");
			});
		},
		getDataById :function(id) {
			this.pushLoadStack()
			let params = {id :id};
			getGoods(params).then(res=>{
				this.infoObj = true;
				this.detailObj = res.data.data;
			});
			this.completeLoad();
		},
	    handleAdd :function(){
	    	this.popupVisible =true;
    		this.editFormTtile = '新增';
	    	this.editForm.phone  = '';
			this.editForm.username = '';
			this.editForm.addr = '';
			this.editForm.email = '';
			this.editForm.phone = '';
			this.editForm.price = this.detailObj.goodsPrice;
			this.editForm.number = 1;
			this.editForm.total = this.getTotal();
	    },
	    getOneCart:function(params){
				getCartOne(params).then(res=>{
			    	return res.data.data;
	    		});
	    },
	    updateCart: function(){
	    		let params = { 
					goods:{
						id: this.$route.params.id
					},
					user :{
						id : this.$store.state.user.id
					}
				};
				if(this.$store.state.user.login){
					getCartOne(params).then(res=>{
	    			if(res.data.data){
			    		this.CartBtnStr = '该商品已加入购物车';
			    		this.Cartdisabled = true;
	    			}else{
			    		this.Cartdisabled = false;
			    		this.CartBtnStr = '请加入购物车';
	    			}
	    		});
				}
	    },
	    handleAddCart: function(){
	    	if(this.islogin){
		    	MessageBox({
				  title: '提示',
				  message: '确定要加入购物车?',
				  showCancelButton: true
				}).then(action=>{
					let params = { 
						goods:{
							id: this.$route.params.id
						},
						user :{
							id : this.$store.state.user.id
						},
						number : 1
						};
					if(this.getOneCart(params)){
						MessageBox('提示','此商品已经加入购物车');
						return;
					}
					addCart(params).then(res=>{
					this.Cartdisabled = true;
				//	this.btnEditText = '已添加';
					this.CartBtnStr = '已添加到购物车';
					})
				});
	    	}else{
				this.loginVisible = true;
			}
	    },
	    editSubmit: function(){
	    	var _this = this;
	    	if(this.editForm.number == 0){
	    		MessageBox.alert("数量不能为0", "数量错误");
	    		return false;
	    	}
	    	if(!this.$store.state.user.login){
	    		MessageBox.alert("请先登录", "未登录");
				this.popupVisible =false;
				this.loginVisible = true;
	    		return false;
	    	}
	    	
	    	MessageBox.confirm('确认提交吗?').then(action => {
				_this.btnEditText = '提交中';
						//新增
						//this.$store.state.user.id
		    	let userid = this.$store.state.user.id;
		    	let goodsid = this.$route.params.id;
				let para = {
					username: _this.editForm.username,
					addr: _this.editForm.addr,
					email: _this.editForm.email,
					phone: _this.editForm.phone,
					price: _this.editForm.price,
					number:_this.editForm.number,
					total : _this.editForm.total,
					user : {id : userid},
					goods : {id: goodsid}
				};
				addOrder(para).then((res) => {
					console.log(res.data);
					MessageBox('提示', '操作成功');
				});
				_this.popupVisible = false;
	    	});
	    },
	    getStoreUser (){
	    	console.log(this.$store.state.user.id);
	    }
	},
	created () {
		 //this.storeUser({id : 11,username : ""});
		//this.getStoreUser();
		console.log(this.$route.path);
		let id = this.$route.params.id
		this.getDataById(id);
		this.completeLoad();
		this.updateCart();
	},
}
</script>

<style>
.border-1px-bottom {
	border-bottom: 1px solid #d9d9d9;
}
.mbg {
	height: 10rem;
	height: 50vmin;
	background: url('../../assets/images/mbg.png') no-repeat;
	background-size: 100% auto;
	padding-left: 15px;
	overflow: hidden;
	box-sizing: border-box;
}
.d-cover {
	position: absolute;
	bottom: 0;
	z-index: 1;
	background: #ccc;
	width: 33.10vmin;
	min-width: 6.25rem;
	min-width: 31.3vmin;
	height: 46.3vmin;
}
.popup{
	    height: 470px;
	    width:370px;
}
.d-cover img {
	width: 100%;
	height: 100%;
}
.d-info {
	display: inline-block;
	margin: 3.8vmin 0 0 37.5vmin;
	color: #fff;
}
.d-info p {
	opacity: .8;
	font-size: .75rem;
	line-height: .875rem;
	line-height: 4.4vmin;
	margin-bottom: .375rem;
	margin-bottom: 1.9vmin;
	width: auto;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
.d-info p.d-name {
	position: relative;
	font-size: 1.125rem;
	line-height: 1.5rem;
	line-height: 7.5vmin;
	max-height: 3rem;
	max-height: 15vmin;
	overflow-y: hidden;
	margin-bottom: .375rem;
	margin-bottom: 1.9vmin;
	color: #fff;
	opacity: 1;
}
.mbg .full-star {
/*	margin-top: 6vmin;*/
}
.mbg .score {
	right: -32px;
	top: 1px;
	color: #fff;
	font-size: 12px;
}
.mbg .full-star {
	width: 70px;
	height: 14px;
}
.buy{
	font-size:20px;
}
.intro-block {
}
.d-intro {
	padding: 20px 15px;
	box-sizing: border-box;
	background-color: #fff;
}
.d-intro p {
	word-break: break-word;
	margin-bottom: .75rem;
	margin-bottom: 3.8vmin;
	font-size: .9375rem;
	line-height: 1.5rem;
	line-height: 7.5vmin;
	color: #333;
	overflow: hidden;
}
.d-intro p.d-control {
	text-align: center;
	font-size: 1.1rem;
}
.ab-photo {
	padding: 15px 15px 25px;
	box-sizing: border-box;
	background-color: #fff;
}
.crew-ab-photo {
	padding: 15px 15px 0px;
}
.ab-header {
	z-index: 1000;
}
.ab-header span {
	font-size: .9375rem;
	line-height: 2rem;
	line-height: 10vmin;
	color: #000;
}
.hide-something {
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 3;
	overflow: hidden;
}
.am-img {
	height: 124px;
}
.crew-img {
	height: 100px;
}
.am-img img{
	height: 100%;
	width: auto;
}
.am-title {
	width: 100%;
}
.am-title p {
	text-align: center;
}
.am-title p:first-child {
	color: #333;
	font-size: 13px;
}
.am-title p:last-child {
	color: #999;
	font-size: 11px;
}
#movie-detail .swiper-container {
	height: 202px;
  width: 100%;
  overflow: initial;
  overflow-x: hidden;
}
#movie-detail .crew-swiper-container {
	margin-top: 7px;
	height: 165px;
}
#movie-detail .swiper-slide {
  text-align: center;
  font-size: 18px;
  background: #fff;
  width: auto;
  display: -webkit-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
}
#movie-detail .swiper-slide:nth-child(2n),
#movie-detail .swiper-slide:nth-child(3n) {
    width: auto;
}
.no-data {
	padding: 60px;
	font-size: 16px;
	color: #666;
	text-align: center;
}
</style>

