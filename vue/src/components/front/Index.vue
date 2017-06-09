<template>
  <section style="height: 100%">
    <city></city>
    <header class="home-header border-bottom">
      <div class="city fl" @click="showCityList">
        <span class="vm city-name f14">{{ $store.state.city.name }}</span>
        <span class="city-arrow-icon vm"></span>
      </div>
      <div class="sel-lists f14 fl pr" @click="moveTab">
        <div hot='sel' :class="{selnav: selnav}">应季蔬菜</div>
        <div :class="{selnav: !selnav}">特卖农产品</div>
        <span class="move pa" :style="{left: moveDistance}"></span>
      </div>
    </header>
    <section  v-show="selnav"  class="content">
       <swiper :imgs="imgs"></swiper>
      <hot :hotLists="hotLists"></hot>
    </section>
    <section  v-show="!selnav"  class="content">
      <coming :comingLists="comingLists" ></coming>
      <div class="click-load-more" @click="clickLoadMore">
        <span v-show="clickLoadStatus === 'start'">点击查看更多</span>
        <div v-show="clickLoadStatus === 'loading'" class="loading-icon">
          <span>加载中</span>
          <mt-spinner style="display: inline-block" type="fading-circle" color="rgb(100, 100, 100)" :size="19"></mt-spinner>
        </div>
        <span v-show="clickLoadStatus === 'complete'">已经全部显示</span>
      </div>
    </section>
   <play-video></play-video>
   
  </section>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
import hot from './hot'
import city from './city'
import coming from './coming'
import playVideo from './playVideo'
import swiper from './swiper'
import {getGoodsListPage,addGoods,removeGoods,editGoods,getGoods} from '../../services/api/api'

export default {
  data () {
    return {
      moveDistance: '5%',
      imgs: [],
      comingLists: [],
      loadingLists: [],
      selnav: true,
      clickLoadStatus: 'start',
      offset: 0,
      limit: 2,
      page : 0,
      total: 0
    }
  },
  components: {
    hot,
    city,
    coming,
    playVideo,
    swiper
  },
  computed: mapGetters([
    'hotLists'
  ]),
  
  methods: {
    ...mapMutations([
      'pushLoadStack',
      'completeLoad',
      'showCityList',
      'storeUser',
      'pushComingList',
    ]),
    moveTab (event) {
      event.target.getAttribute('hot') ? this.selectHotTab() : this.slectComingTab()
    },
    selectHotTab () {
      this.selnav = true
      this.moveDistance = '5%'
       this.getList();
     this.pushComingList({lists: this.comingLists})
    
//      this.pushComingList({lists: []})
    },
    slectComingTab () {
      this.selnav = false
      this.moveDistance = '55%'
       this.getList();
     this.pushComingList({lists: this.comingLists})
    
//      this.pushComingList({lists: this.loaingLists})
    },
    getWeekDay (num) {
      let weeks = ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
      return weeks[num]
    },
    clickLoadMore () {
      if (this.clickLoadStatus != 'complete') {
        this.clickLoadStatus = 'loading',
        setTimeout(() => {
          this.page =this.page+1;
          this.getList();
          
          if (this.offset < this.total) {
              this.clickLoadStatus = 'start'
          } else {
              this.clickLoadStatus = 'complete'
          }
        }, 500)
        this.completeLoad;
      }
    },
    requestData (url, fn) {
      this.pushLoadStack()
      this.$http.get(url).then(fn).then(this.completeLoad)
    },
    sortComingData (lists) {
      return lists
    },
    getList:function() {
      let params ={
        size : this.limit,
        page : this.page
      };
      getGoodsListPage(params).then(res =>{
        this.loadingLists = res.data.data.content;
        this.comingLists = res.data.data.content;
        this.total = res.data.data.totalElements;
        this.offset = this.offset + this.limit;
        this.page = this.page +1;
        console.log(this.loadingLists);
        this.pushComingList({lists: this.comingLists});
      });
     
    }
  },
  mounted:function(){
  },
  created:function(){ 
     this.getList();
     this.pushComingList({lists: this.comingLists})
     this.completeLoad();
  }
}
</script>

<style>
.home-header {
  height: 40px;
  background-color: #fff;
}
.selnav {
  color: #ff4d64;
}
.city {
  width: 35%;
  height: 100%;
  line-height: 40px;
  text-align: center;
  display: inline-block;
}
.city-arrow-icon {
  margin-left: 4px;
  width: 12px;
  height: 12px;
  display: inline-block;
}
.city-arrow-icon:after {
  content: "";
  display: block;
  width: 6px;
  height: 6px;
  margin-left: 0;
  border: 1px solid #50505a;
  border-top: 0 none;
  border-left: 0 none;
  margin-left: 2px;
  -webkit-transform: rotate(45deg);
  transform: rotate(45deg);
}
.content {
  margin-bottom: 58px;
}
.sel-lists {
  width: 65%;
  display:-moz-box; 
  display: -webkit-box;
  display: box;
}
.sel-lists div {
  -moz-box-flex: 1.0; 
  -webkit-box-flex: 1.0; 
  line-height: 40px;
  text-align: center;
}
.move {
  display: inline-block;
  bottom: 0px;
  width: 40%;
  border-bottom: 3px solid #ff4d64;
  -webkit-transition: left 0.7s ease-in-out;
  transition: left 0.7s ease-in-out;
}
.click-load-more {
  height: 42px;
  line-height: 42px;
  text-align: center;
  color: #333;
  font-size: 15px;
  background-color: #fff;
  margin: 5px 0 8px;
}
.loading-icon span {
  vertical-align: middle;
}
.fl {
  float:left;
}
</style>
