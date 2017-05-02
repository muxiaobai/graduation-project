<template>
  
  <div class="hello">
    <el-form :model="editForm" label-width="80px" ref="editForm">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="editForm.username"></mt-field>
    <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="editForm.email"></mt-field>
    <mt-field label="密码" placeholder="请输入密码" type="password" v-model="editForm.password"></mt-field>
    <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="editForm.phone"></mt-field>
    <mt-field label="生日" placeholder="请输入生日" type="date" v-model="editForm.birthday"></mt-field>
    <mt-field label="自我介绍" placeholder="自我介绍" type="textarea" rows="4" v-model="editForm.introduction"></mt-field>
    <el-button type="primary" @click.native="editSubmit">{{btnEditText}}</el-button>
    </el-form>
  
  </div>
  
</template>

<script>
import {addUser} from '../../services/api/api'
export default {
  data () {
    return {
      	//编辑界面数据
				editForm: {
    			username: '',
          email:'',
          password:'',
          phone:'',
          birthday:'',
          introduction:''
				},
				btnEditText: '提 交',
    }
  },
  methods:{
      editSubmit: function(){
        let para = {
          username:	this.editForm.username,
          password: this.editForm.password,
         
		  	};
			  console.log(para);
      	addUser(para).then((res) => {
    	  console.log("拟稿");
			});
    },
  }
}
</script>

<style scoped>
.hello{
  background-color:#FFF;
}
</style>
