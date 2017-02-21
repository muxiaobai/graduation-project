<template>
<section  class="goodsdetail">
		<!--工具条查询框-->
		<el-col :span="24" class="toolbar">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.name" placeholder="姓名"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="getUsers">查询</el-button>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="handleAdd">新增</el-button>
				</el-form-item>
			</el-form>
		</el-col>

<!--列表-->
<template>
		<el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">
    <el-table-column type="index" width="60">
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="120" sortable>
    </el-table-column>
    <el-table-column prop="sex" label="性别" width="100" :formatter="formatSex" sortable>
    </el-table-column>
    <el-table-column prop="age" label="年龄" width="100" sortable>
    </el-table-column>
    <el-table-column prop="birth" label="生日" width="120" sortable>
    </el-table-column>
    <el-table-column prop="addr" label="地址" min-width="180" sortable>
    </el-table-column>
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
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
</el-col>


</section>
</template>

<script>
import Top from '../include/Top'
import {getUserListPage} from '../../services/api/api'
export default {
  name: 'goodsdetail',
  components: {
     Top
  },
  data: function() {
    	return {
				filters: {
					name: ''
				},
				users: [],
				total: 1,
				page: 1,
				currentPage: 1,
				listLoading: false,
				editFormVisible: false,//编辑界面显是否显示
				editFormTtile: '编辑',//编辑界面标题
				//编辑界面数据
				editForm: {
					id: 0,
					name: '',
					sex: -1,
					age: 0,
					birth: '',
					addr: ''
				},
				editLoading: false,
				btnEditText: '提 交',
				editFormRules: {
					name: [
						{ required: true, message: '请输入姓名', trigger: 'blur' }
					]
				}

			}
  },
   methods: {
    handleClick: function() {
      this.$toast('Hello world!')
    },
    formatSex: function(row,column) {
      	return row.sex == 1 ? '男' : row.sex == 0 ? '女' : '未知';
    },
    getUsers:function() {
      console.log("user"+this.filters.name);
      let para = {
					page: this.page,
					name: this.filters.name
				};
				this.listLoading = true;
				getUserListPage(para).then((res) => {
					this.total = res.data.total;
					this.users = res.data.users;
					this.listLoading = false;
				});
      return 
    },
    handleAdd : function() {
      console.log("add")
    },
    handleEdit: function(row) {
        console.log(row+"edit")
    },
    handleDel: function(row) {
      console.log(row+"del")
    },
    //分页有关的两个方法
    handleCurrentChange: function(val){
      console.log(val);
    },
    handleSizeChange: function(val) {
      console.log(val);
    }
    
  }
}

</script>

<style scoped>

</style>
