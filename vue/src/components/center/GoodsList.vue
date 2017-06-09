<template>
<section  class="goodsdetail">
		<!--工具条查询框-->
		<el-col :span="24" class="toolbar">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.goodsName" placeholder="商品名称"></el-input>
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
		<el-table :data="goods" highlight-current-row v-loading="listLoading" style="width: 100%;">
	
    <el-table-column type="index" width="60">    </el-table-column>
    <el-table-column prop="goodsName" label="产品名称" width="120" >    </el-table-column>
    <el-table-column prop="goodsType" label="类型" width="100" :formatter="formatSex" >    </el-table-column>
    <el-table-column prop="goodsDate" label="生产日期" width="120" :formatter="formatDate"  sortable>    </el-table-column>
    <el-table-column prop="goodsPrice" label="价格(单位：元)" width="140" sortable>   元 </el-table-column>
    <el-table-column prop="goodsIntro" label="简介" min-width="150" >    </el-table-column>
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
		<el-form-item label="商品名称" prop="name">
			<el-input v-model="editForm.goodsName" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="类别">
			<el-radio-group v-model="editForm.goodsType">
				<el-radio class="radio" :label="1">正常</el-radio>
				<el-radio class="radio" :label="2">热卖</el-radio>
				<el-radio class="radio" :label="3">即将上市</el-radio>
			</el-radio-group>
		</el-form-item>
		<el-form-item label="商品价格">
			<el-input-number v-model="editForm.goodsPrice" :min="0" :max="200"></el-input-number>
		</el-form-item>
		<el-form-item label="优惠活动">
			<el-select v-model="editForm.goodsPrefer.id"  placeholder="editForm.goodsPrefer.intro" >
       		 <span v-for = 'preferential in preferentials'>
			     <el-option :label="preferential.intro" :value="preferential.id"></el-option>
			</span>
     	 	</el-select>
		</el-form-item>
		<el-form-item label="商品库存">
			<el-input-number v-model="editForm.goodsStock" :min="0" :max="200"></el-input-number>
		</el-form-item>
		<el-form-item label="生产日期">
			<el-date-picker type="date" placeholder="选择日期" v-model="editForm.goodsDate"></el-date-picker>
		</el-form-item>
		<el-form-item label="商品封面图片">
			<el-input type="textarea" v-model="editForm.avatar"></el-input>
		</el-form-item>
		<el-form-item label="商品简介">
			<el-input type="textarea" v-model="editForm.goodsIntro"></el-input>
		</el-form-item>
		<el-form-item label="详细介绍">
			<el-input type="textarea" v-model="editForm.detailIntro"></el-input>
		</el-form-item>
		<el-form-item label="详细图片">
			<el-input type="textarea" v-model="editForm.detailFile1"></el-input>
		</el-form-item>
		<el-form-item label="详细图片">
			<el-input type="textarea" v-model="editForm.detailFile2"></el-input>
		</el-form-item>
			<el-form-item label="详细图片">
			<el-input type="textarea" v-model="editForm.detailFile3"></el-input>
		</el-form-item>
			<el-form-item label="详细图片">
			<el-input type="textarea" v-model="editForm.detailFile4"></el-input>
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
import {getGoodsListPage,addGoods,removeGoods,editGoods,getGoods,getPreferentialList} from '../../services/api/api'
export default {
  name: 'goodsdetail',
  components: {
     Top
  },
  data: function() {
    	return {
				filters: {
					goodsName: ''
				},
				goods: [],
				preferentials:[],
				preferentialintro:'请选择优惠活动',
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
					goodsName: '',
					goodsType: 1,
					goodsPrice: 0,
					goodsDate: '',
					goodsIntro: '',
					goodsStock: 100,
					goodsPrefer: {
						id : 1, 
						intro: '请选择优惠活动'
					},
					avatar : '',
					detailFile1 :'',
					detailFile2 :'',
					detailFile3 :'',
					detailFile4 :'',
					
				},
				editLoading: false,
				btnEditText: '提 交',
				editFormRules: {
					goodsName: [
						{ required: true, message: '请输入姓名', trigger: 'blur' }
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
    	return (new Date(row.goodsDate)).toLocaleDateString();
    },
    handleCreatedPreferential:function(){
    	let params ={
			page: this.currentPage,
			size: this.pageSize,
    	};
    	getPreferentialList(params).then(res=>{
    		this.preferentials = res.data.data.content;
    		console.log(this.preferentials);
    	});
    },

    //CRUD
    getList:function() {
      let para = {
					page: this.currentPage,
					size: this.pageSize,
					goodsName: this.filters.goodsName
				};
				this.listLoading = true;
				getGoodsListPage(para).then((res) => {
					this.total = res.data.data.totalElements;
					this.goods = res.data.data.content;
					this.listLoading = false;
				});
		return
    },
    handleAdd : function() {
		this.editFormVisible= true;
    	this.editFormTtile = '新增';
		this.editForm.id = 0;//重置参数,0为新增，其他为修改
		this.editForm.goodsName = '';
		this.editForm.goodsType = 1;
		this.editForm.goodsPrice = 0;
		this.editForm.goodsDate = '';
		this.editForm.goodsIntro = '';
		this.editForm.detailIntro = '';
		this.editForm.goodsStock = 100;
		this.editForm.goodsPrefer.id = 1;
		this.editForm.goodsPrefer.intro = "选择优惠活动";
		
	},
    handleDel: function(row) {
      	var _this = this;
		this.$confirm('确认删除该记录吗?', '提示', {
			//type: 'warning'
		}).then(() => {
			_this.listLoading = true;
			let para = { id: row.id };
			removeGoods(para).then((res) => {
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
		getGoods(para).then((res) => {
			let edit = res.data.data;
			this.editForm.goodsName = edit.goodsName;
			this.editForm.goodsType = edit.goodsType;
			this.editForm.goodsPrice = edit.goodsPrice;
			this.editForm.goodsDate = edit.goodsDate;
			this.editForm.goodsIntro = edit.goodsIntro;
			this.editForm.detailIntro = edit.detailIntro;
			this.editForm.goodsStock = edit.goodsStock;
			this.editForm.goodsPrefer = edit.preferential;
			this.editForm.avatar = edit.avatar;
			this.editForm.detailFile1 = edit.detailFile1;
			this.editForm.detailFile2 = edit.detailFile2;
			this.editForm.detailFile3 = edit.detailFile3;
			this.editForm.detailFile4 = edit.detailFile4;
			
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
									goodsName: _this.editForm.goodsName,
									goodsType: _this.editForm.goodsType,
									goodsPrice: _this.editForm.goodsPrice,
									goodsDate: _this.editForm.goodsDate,
									goodsIntro: _this.editForm.goodsIntro,
									detailIntro:_this.editForm.detailIntro,
									goodsStock : _this.editForm.goodsStock,
									preferential :{ id : _this.editForm.goodsPrefer.id}
								};
								addGoods(para).then((res) => {
								  this.closeEdit(_this,'成功','提交成功','success');
								});
							} else {
								//编辑
								let para = {
									id : _this.editForm.id,
									goodsName: _this.editForm.goodsName,
									goodsType: _this.editForm.goodsType,
									goodsPrice: _this.editForm.goodsPrice,
									goodsDate: _this.editForm.goodsDate,
									goodsIntro: _this.editForm.goodsIntro,
									detailIntro:_this.editForm.detailIntro,
									goodsStock :_this.editForm.goodsStock,
									preferential :{ id : _this.editForm.goodsPrefer.id},
									avatar :_this.editForm.avatar,
									detailFile1 :_this.editForm.detailFile1,
									detailFile2 :_this.editForm.detailFile2,
									detailFile3 :_this.editForm.detailFile3,
									detailFile4 :_this.editForm.detailFile4,
								};
								console.log(para);
								editGoods(para).then((res) => {
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
  	this.handleCreatedPreferential();
  },
}

</script>

<style scoped>

</style>
