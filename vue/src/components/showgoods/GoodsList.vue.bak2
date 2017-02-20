<template>
<section  class="goodsdetail">
		<!--工具条-->
		<el-col :span="24" class="toolbar">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.name" placeholder="姓名"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" v-on:click="getUsers">查询</el-button>
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
<el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="20" :total="total" style="float:right;">
</el-pagination>
</el-col>


</section>
</template>

<script>
import Top from '../include/Top'
export default {
  name: 'goodsdetail',
  components: {
     Top
  },
  data: function() {
    return {
      msg: 'Welcome to Your Vue.js App, this is GoodsList.vue'
    }
  },
   methods: {
    handleClick: function() {
      this.$toast('Hello world!')
    }
  }
}

</script>

<style scoped>

</style>
