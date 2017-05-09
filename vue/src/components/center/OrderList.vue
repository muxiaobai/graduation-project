<template>
<section  class="goodsdetail">
		<!--工具条查询框-->
		<el-col :span="24" class="toolbar">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.username" placeholder="收货人"></el-input>
				</el-form-item>
				<el-form-item>
					<el-input v-model="filters.phone" placeholder="收货人联系方式"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="getList">查询</el-button>
				</el-form-item>
			</el-form>
		</el-col>
<!--列表-->
<template>
		<el-table :data="list" highlight-current-row v-loading="listLoading" style="width: 100%;">
    <el-table-column type="index" width="60">
    </el-table-column>
    <el-table-column prop="username" label="收货人" width="120" >
    </el-table-column>
    <el-table-column prop="phone" label="收货号码" width="100" >
    </el-table-column>
    <el-table-column prop="total" label="总计" width="100"sortable>
    </el-table-column>
    <el-table-column prop="goods.goodsName" label="商品名称" width="120" >
    </el-table-column>
    <el-table-column prop="addr" label="地址" min-width="180" >
    </el-table-column>
    <el-table-column inline-template :context="_self" label="操作" width="150">
    	<span>
      	<el-button size="small" @click="handleEdit(row)">编辑</el-button>
    	</span>
    </el-table-column>
    </el-table>
</template>

<!--分页-->
<el-col :span="24" class="toolbar" style="padding-bottom:10px;">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[20, 40, 60, 100]"
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
</el-col>


<!--编辑界面-->
<el-dialog :title="editFormTtile" v-model="editFormVisible" :close-on-click-modal="false">
	<el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
		<el-form-item label="收货人" prop="name">
			<el-input v-model="editForm.username" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="收货手机号" prop="name">
			<el-input v-model="editForm.phone" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="商品名称">
			<el-input v-model="editForm.goods_name" readonly ></el-input>
		</el-form-item>
		<el-form-item label="商品单价">
			<el-input v-model="editForm.price" readonly ></el-input>
		</el-form-item>
		<el-form-item label="数量">
			<el-input-number v-model="editForm.number" :min="1" :max="200"></el-input-number>
		</el-form-item>
		<el-form-item label="总计">
			<el-input v-model="editForm.total"  readonly ></el-input>
		</el-form-item>
		<el-form-item label="地址">
			<el-input type="textarea" v-model="editForm.addr"></el-input>
		</el-form-item>
	</el-form>
	<div slot="footer" class="dialog-footer">
		<el-button @click.native="editFormVisible = false">取 消</el-button>
		<el-button type="primary" @click.native="editSubmit" :loading="editLoading">{{btnEditText}}</el-button>
	</div>
</el-dialog>

</section>

</template>

<script>
import Top from '../include/Top'
import {getOrderListPage,editOrder,getOrder} from '../../services/api/api'
export default {
  name: 'order',
  components: {
     Top
  },
  data: function() {
    	return {
				filters: {
					name: ''
				},
				list: [],
				total: 1,
				page: 1,
				currentPage: 1,
				listLoading: false,
				editFormVisible: false,//编辑界面显是否显示
				editFormTtile: '编辑',//编辑界面标题
				//编辑界面数据
				editForm: {
					id: 0,
					username: '',
					phone: '',
					price : 0,
					number: 1,
					total : 0,
					goods_id : 0,
					goods_name: '',
					user_id : 0,
					user_name: '',
				},
				editLoading: false,
				btnEditText: '提 交',
				editFormRules: {
					username: [
						{ required: true, message: '请输入姓名', trigger: 'blur' }
					],
					phone :[
						{ required:true, message :'请输入收货人电话',trigger:'blur'}
						]
				}

			}
  },
  	watch: {
		'editForm.number' : function(val){
            this.editForm.total = this.editForm.price*val == 0? 0 :this.editForm.price * val;
		}
	},
   methods: {
    handleClick: function() {
      this.$toast('Hello world!')
    },
    formatSex: function(row,column) {
      	return row.sex == 1 ? '男' : row.sex == 0 ? '女' : '未知';
    },
    //CRUD
    getList:function() {
    	let para = {
			page: this.page,
			username: this.filters.username,
			phone : this.filters.phone,
		};
		this.listLoading = true;
		getOrderListPage(para).then((res) => {
			console.log(res.data.data);
			this.total = res.data.data.totalElements;
			this.list = res.data.data.content;
			this.listLoading = false;
		});
    },
    handleEdit: function(row) {
        this.editFormVisible= true;
        this.editFormTtile = '编辑';
		this.editForm.id = row.id;
		let params = {
			id : row.id
		}
		getOrder(params).then(res=>{
			let data = res.data.data;
			console.log(data);
			this.editForm.username = data.username;
			this.editForm.phone = data.phone;
			this.editForm.number = data.number;
			this.editForm.price = data.goods.goodsPrice ;
			this.editForm.total = this.editForm.price*this.editForm.number == 0? 0 :this.editForm.number * this.editForm.price;
			this.editForm.user_id = data.user.id;
			this.editForm.user_name = data.user.username;
			this.editForm.goods_id  = data.goods.id;
			this.editForm.goods_name  = data.goods.goodsName;
			this.editForm.addr = row.addr;
		});
	
    },
    editSubmit: function(){
    	var _this = this;
		_this.$refs.editForm.validate((valid) => {
			if (valid) {
				_this.$confirm('确认提交吗？', '提示', {}).then(() => {
					_this.editLoading = true;
					_this.btnEditText = '提交中';
					//编辑
					let para = {
						id : _this.editForm.id,
						username : _this.editForm.username,
						addr: _this.editForm.addr,
						email: _this.editForm.email,
						number: _this.editForm.number,
						addr: _this.editForm.addr,
						phone: _this.editForm.phone,
						total: _this.editForm.total,
						user:{
							id :_this.editForm.user_id
						},
						goods :{
							id :_this.editForm.goods_id
						},
					};
					editOrder(para).then((res) => {
					  this.closeEdit(_this,'成功','提交成功','success');
					});
				});

			}
		});
    },
    closeEdit: function (para,title,message,type) {
      	para.editLoading = false;
				para.btnEditText = '提 交';
				para.$notify({
					title: title,
					message: message,
					type: type
				});
				para.editFormVisible = false;
				para.getList();
    },
   //分页有关的两个方法,改变当前页，和修改每页的数量
    handleCurrentChange: function(val){
      this.currentPage = val;
	  this.getList();
    },
    handleSizeChange: function(val) {
      this.pageSize = val;
      this.getList();
    },
    mounted: function() {
		this.getList();
	}
    
  },
  created :function(){
  	this.getList();
  	console.log(this.list);
  }
}
</script>

<style scoped>

</style>
