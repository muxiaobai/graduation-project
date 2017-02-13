<template>


<section class="panel-c-c">
	<div class="grid-content bg-purple-light">
		<el-col :span="24" style="margin-bottom:15px;">
			<strong style="width:200px;float:left;color: #475669;">{{$route.name}}</strong>
			<el-breadcrumb separator="/" style="float:right;">
				<el-breadcrumb-item v-for="item in $route.matched">
					{{ item.name }}
				</el-breadcrumb-item>
			</el-breadcrumb>
		</el-col>
		<el-col :span="24" style="background-color:#fff;box-sizing: border-box;">
			<!--<transition name="fade">-->
			<router-view></router-view>
			<!--</transition>-->
		</el-col>
	</div>
</section>

</template>