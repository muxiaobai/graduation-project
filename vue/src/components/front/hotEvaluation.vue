<template>
	<section id="hot-evaluation">
		<h1>sdfsdfsdf</h1>
		asdaads
	</section>
</template>
<script> 
export default{
	data () {
		return {
		}
	},
	props: {
		lists: {
			type: Array,
			default: () => []
		}
	},
	components: {
	},
	created:function(){
		console.log("hot");
		console.log(this.props.lists);
	}
}
</script>

<style>
#hot-evaluation {
	background-color: #fff;
	padding-left: 15px;
}
.h-e-header {
	padding: 12px 0;
} 
.h-e-header span:first-child {
	color: #000;
	font-size: 16px;
	font-weight: bold;
}
.h-e-header span:last-child {
	color: #666
}
.evl-item {
	padding-top: 10px;
}
.he-u-icon {
	width: 25px;
	height: 25px;
	border-radius: 100%;
	overflow: hidden;
}
.he-u-icon img {
	width: 100%;
	height: 100%;
}
.he-u-content {
	margin-left: 30px;
	padding-right: 10px;
	box-sizing: border-box;
}
#hot-evaluation .full-star,
.he-u-name {
	display: inline-block;
	vertical-align: middle;
}
#hot-evaluation .full-star {
	margin-top: -1px;
}
.he-u-name {
	max-width: 60px;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
	font-size: 14px;
	color: #000;
	font-weight: bold;
}
.he-u-time {
	color: #666;
	font-size: 10px;
	margin-top: 4px;
}
.he-u-say {
	font-size: 12px;
	line-height: 20px;
	padding: 5px 0 15px;
}
.no-more {
	text-align: center;
	padding: 15px 0 10px;
	font-size: 14px;
	color: #666;
}
</style>

