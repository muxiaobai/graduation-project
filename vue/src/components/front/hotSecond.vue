<template>
	<section class="cinema-box" style="margin-top: 40px; background: #fff">
		<ul class="cm-item">
			<li v-for="item in demands">
				<!--<router-link :to="{ name: 'detail', params: { id: item.id }}">	
				</router-link>
				-->
					<div class="cm-name">
						<span class="tddd vm">{{ item.demand }}</span>
						<span class="k-mode vm" v-show="item.type === '1'">急需</span>
						<span class="k-mode vm" v-show="item.type === '2'">常规</span>
						<span class="k-mode vm" v-show="item.type === '3'">长久需求</span>
					</div>
					<p class="cm-address tddd">截止时间：{{ new Date(item.deadline).toLocaleDateString()   }}</p>
					<p class="cm-address tddd">{{ item.detail }}</p>
					<div class="cm-welfare">
						<span class="label-mod label-border-blue">货源充足</span>
						<span class="label-mod label-orange">新人专享</span>
						<span class="label-mod">{{item.price}}元/份</span>
						<span class="label-mod label-orange" @click='addMyDemands'>关注该需求</span>
					</div>
				
			</li>
		</ul>
		<div style="height: 60px; background: #f5f5f5"></div>
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
import { mapGetters, mapMutations } from 'vuex'
import {addDemands,removeDemands,editDemands,getDemandsOne,getDemandsListPage} from '../../services/api/api'

export default {
    data () {
        return {
            demands:[],
        }
    },
    methods: {
        ...mapMutations([
          'pushDemandsList',
        ]),
        pushStore: function(){
            getDemandsListPage().then(res=>{
                let data = res.data.data.content;
                this.demands = data;
                console.log(res.data.data.content);
                this.pushDemandsList({lists:data});
            })
        },
        addMyDemands: function(){
            
        },
    },
    created:function(){
        this.pushStore();
       // console.log(this.$store.state.coming.goods);
    }
    
}
</script>
<style>
.cm-item {
	padding-left: 15px;
	box-sizing: border-box;
}
.cm-item li {
	padding: 15px 15px 12px 0px;
	border-bottom: 1px solid #ebebeb;
}
.cm-item li:last-child {
	border-bottom: 0px;
}
.cm-name {
	font-weight: 400;
	color: #424242;
	font-size: 16px;
}
.cm-name span:first-child {
	max-width: 83%;
}
.cm-address {
	color: gray;
	font-size: 10px;
}
.cm-welfare {
	font-size: 10px;
	color: gray;
}
.cm-address, .cm-welfare {
	margin-top: 10px;
}
.label-mod.label-border-blue {
	border: 1px solid #00b8f0;
	color: #00b8f0;
}
.label-mod.label-orange {
	background: #ff8625;
    border-color: #ff8625;
    color: #fff;
}
.label-mod {
	display: inline-block;
	margin: 0 1px;
	padding: 0 1px;
	line-height: 14px;
	min-width: 12px;
	font-size: 12px;
	text-align: center;
	border-radius: 2px;
	font-weight: 400;
	border: 1px solid transparent;
}
.k-mode {
	display: inline-block;
	border: 1px solid #adb6ca;
	color: #adb6ca;
	overflow: hidden;
	border-radius: 2px;
	font-size: 12px;
}
</style>