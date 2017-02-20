<template>
<aside style="width:230px;">
    <h1 style="background-color:#fff"></h1>
    <el-menu :default-active="$route.path" class="el-menu-vertical-demo" @open="handleopen" @close="handleclose" @select="handleselect" theme="dark" unique-opened router>
        <template v-for="(item,index) in $router.options.routes" v-if="!item.hidden">
            <el-submenu :index="index+''" v-if="!item.leaf">
                <template slot="title">
                    <i :class="item.iconCls">
                    </i>
                    {{item.name}}
                </template>
                
                <el-menu-item v-for="child in item.children" :index="child.path" v-if="!child.hidden">
                    {{child.name}}
                </el-menu-item>
            </el-submenu>
            
            <el-menu-item v-if="item.leaf&&item.children.length > 0" :index="item.children[0].path">
                <i :class="item.iconCls">
                </i>
                {{item.children[0].name}}
            </el-menu-item>
        </template>
    </el-menu>
</aside>
</template>
<script>
export default {
    data() {
        return {
            routesub:'11'
        }
    },
    methods: {
    	onSubmit() {
    		console.log('submit!');
    	},
    	handleopen() {
    		console.log('handleopen');
    	},
    	handleclose() {
    		console.log('handleclose');
    	},
    	handleselect: function (a, b) {
    	 //   console.log(a);
    	    this.routesub = a;
    	    this.$emit('routeData',this.a);
    	    console.log(this.$emit('routeData'));
    	}
    }
}

</script>

<style>

</style>