<template>


<section class="center">
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
            <!--</transition>              <router-link to="/goodsmanage/hello">/goodsmanage/hello</router-link> -->
        </el-col>
    </div>
</section>

</template>
<script>
export default {
  name: 'Center',
  data() {
      return {
          routeData: ''
      }
  },
//  props: ['routeData']
}

    
</script>

<style>
.center {
    background: #f1f2f7;
    overflow-y: scroll;
    padding: 20px;
    height: 600px;
}

</style>