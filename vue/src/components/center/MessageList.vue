<template>
<section  class="goodsdetail">
		<!--工具条查询框-->
		<el-col :span="24" class="toolbar">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.goodsName" placeholder="需求简称"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="getList">查询</el-button>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="handleAdd">新增</el-button>
				</el-form-item>
			</el-form>
		</el-col>

<!--列表-->
<template>
		<el-table :data="demands" highlight-current-row v-loading="listLoading" style="width: 100%;">
	
    <el-table-column type="index" width="60">    </el-table-column>
    <el-table-column prop="demand" label="需求名称"  >    </el-table-column>
    <el-table-column prop="type" label="需求类型" width="100" :formatter="formatSex" >    </el-table-column>
    <el-table-column prop="deadline" label="截止日期" width="120" :formatter="formatDate" sortable >    </el-table-column>
    <el-table-column prop="price" label="价格(单位：元)"  >   元 </el-table-column>
    <el-table-column inline-template :context="_self" label="操作" width="150">
    	<span>
      	<el-button size="small" @click="handleEdit(row)">编辑</el-button>
      	<el-button type="danger" size="small" @click="handleDel(row)">删除</el-button>
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
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
</el-col>


<!--编辑界面-->
<el-dialog :title="editFormTtile" v-model="editFormVisible" :close-on-click-modal="false">
	<el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
		<el-form-item label="需求名称" prop="demand">
			<el-input v-model="editForm.demand" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="类别">
			<el-radio-group v-model="editForm.type">
				<el-radio class="radio" :label="1">正常</el-radio>
				<el-radio class="radio" :label="2">热卖</el-radio>
				<el-radio class="radio" :label="3">即将上市</el-radio>
			</el-radio-group>
		</el-form-item>
		<el-form-item label="商品价格">
			<el-input-number v-model="editForm.price" :min="1" :max="200"></el-input-number>
		</el-form-item>
		<el-form-item label="商品需求数量">
			<el-input-number v-model="editForm.num" :min="1" :max="1100"></el-input-number>
		</el-form-item>
		<el-form-item label="截止日期">
			<el-date-picker type="date" placeholder="选择日期" v-model="editForm.deanline"></el-date-picker>
		</el-form-item>
		<el-form-item label="联系人" prop="name">
			<el-input v-model="editForm.name" auto-complete="off"></el-input>
		</el-form-item>
			<el-form-item label="联系电话" prop="tel">
			<el-input v-model="editForm.tel" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="地址">
			<el-input type="textarea" v-model="editForm.addr"></el-input>
		</el-form-item>
		<el-form-item label="商品简介">
			<el-input type="textarea" v-model="editForm.detail"></el-input>
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
import {addDemands,removeDemands,editDemands,getDemandsOne,getDemandsListPage} from '../../services/api/api'
export default {
  name: 'goodsdetail',
  components: {
     Top
  },
  data: function() {
    	return {
				filters: {
					demand: ''
				},
				demands: [],
				total: 1,
				page: 1,
				currentPage: 1,
				pageSize: 20,
				listLoading: false,
				editFormVisible: false,//编辑界面显是否显示
				editFormTtile: '编辑',//编辑界面标题
				//编辑界面数据
				editForm: {
					id: 0,
					demand:'',//简介
					type: '', //需求产品的类型
					name: '',//需求人
					tel: '',//需求人联系方式
					deadline:'',//截止时间
					addr:'',//需求地址
					num:'',//需求数量
					price:'',//需求数量
					detail:'',//需求的一些必备条件要求
				},
				editLoading: false,
				btnEditText: '提 交',
				editFormRules: {
					demand: [
						{ required: true, message: '请输入简称', trigger: 'blur' }
					]
				}

			}
  },
   computed: {
   },
   methods: {
    handleClick: function() {
      this.$toast('Hello world!')
    },
    formatSex: function(row,column) {
      	return row.goodsType == 1 ? '正常' : row.goodsType == 2 ? '热卖' : row.goodsType == 3 ? '即将上市' : '未知';
    },
    formatDate: function(row,column){
    	return (new Date(row.deadline)).toLocaleDateString();
    },


    //CRUD
    getList:function() {
      let para = {
					page: this.currentPage,
					size: this.pageSize,
					goodsName: this.filters.goodsName
				};
				this.listLoading = true;
				getDemandsListPage(para).then((res) => {
					this.total = res.data.data.totalElements;
					this.demands = res.data.data.content;
					this.listLoading = false;
				});
		return
    },
    handleAdd : function() {
		this.editFormVisible= true;
    	this.editFormTtile = '新增';
		this.editForm.id = 0;//重置参数,0为新增，其他为修改
		this.editForm.demand = '';
		this.editForm.type = 1;
		this.editForm.price = 0;
		this.editForm.name = '';
		this.editForm.tel = '';
		this.editForm.addr = '';
		this.editForm.num = 100;
		this.editForm.detail = '';
		this.editForm.deadline = new Date();
	},
    handleDel: function(row) {
      	var _this = this;
		this.$confirm('确认删除该记录吗?', '提示', {
			//type: 'warning'
		}).then(() => {
			_this.listLoading = true;
			let para = { id: row.id };
			removeDemands(para).then((res) => {
				this.closeEdit(_this,'成功','删除成功','success');
			});
			
		}).catch(() => {

		});
    },
    handleEdit: function(row) {
        this.editFormVisible= true;
        this.editFormTtile = '编辑';
		this.editForm.id = row.id;
		let para = { id: row.id };
		getDemandsOne(para).then((res) => {
			let edit = res.data.data;
				this.editForm.id = 0;//重置参数,0为新增，其他为修改
		this.editForm.demand = edit.demand;
		this.editForm.type = edit.type;
		this.editForm.price = edit.price;
		this.editForm.name = edit.name;
		this.editForm.tel = edit.tel;
		this.editForm.addr = edit.addr;
		this.editForm.num = edit.num;
		this.editForm.detail = edit.detail;
		this.editForm.deadline = edit.deadline;
		});
    },
    editSubmit: function(){
      	var _this = this;
				_this.$refs.editForm.validate((valid) => {
					if (valid) {

						_this.$confirm('确认提交吗？', '提示', {}).then(() => {
							_this.editLoading = true;
							_this.btnEditText = '提交中';

							if (_this.editForm.id == 0) {
								//新增
								let para = {
									demand:_this.editForm.demand,//简介
									type: _this.editForm.type, //需求产品的类型
									name: _this.editForm.name,//需求人
									tel: _this.editForm.tel,//需求人联系方式
									deadline:_this.editForm.deadline,//截止时间
									addr:_this.editForm.addr,//需求地址
									num:_this.editForm.num,//需求数量
									price:_this.editForm.price,//需求数量
									detail:_this.editForm.detail,//需求的一些必备条件要求
								
								};
								addDemands(para).then((res) => {
								  this.closeEdit(_this,'成功','提交成功','success');
								});
							} else {
								//编辑
								let para = {
									id : _this.editForm.id,
									demand:_this.editForm.demand,//简介
									type: _this.editForm.type, //需求产品的类型
									name: _this.editForm.name,//需求人
									tel: _this.editForm.tel,//需求人联系方式
									deadline:_this.editForm.deadline,//截止时间
									addr:_this.editForm.addr,//需求地址
									num:_this.editForm.num,//需求数量
									price:_this.editForm.price,//需求数量
									detail:_this.editForm.detail,//需求的一些必备条件要求
								
								};
								console.log(para);
								editDemands(para).then((res) => {
								  this.closeEdit(_this,'成功','提交成功','success');
								});

							}

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
  },
}

</script>

<style scoped>

</style>
