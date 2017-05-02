<template>
<div id = "swiper">
	<mt-swipe :auto="4000">
		<div v-for="item in imgs" >
	  <mt-swipe-item>
	  	<img class="img" :src="'https://gw.alicdn.com/tfs/' + item.smallPicUrl" />
	  </mt-swipe-item>
	</div>
	</mt-swipe>
</div>
</template>

<script>
export default {
  data () {
	  return{
	  }
  },
  props: {
  	imgs: {
  		type: Array,
  		default: () => []
  	}
  },
   watch: {
  	imgs() {
  		this.$nextTick(() => {

  		})
  	}
  }
}
</script>

<style>
	img {
		width: 100%;
		height: auto;
	}
	#swiper{
		height:200px;
	}
	#swiper .swiper-pagination-bullet {
		background: #e5e8e8;
		opacity: 1; 
	}
	#swiper .swiper-pagination-bullet-active {
		background: #ff5733;
	}
</style>