<template>
<div id = "swiper">
	<mt-swipe :auto="4000">
	  <mt-swipe-item>
	  	<img class="img" src="http://img.cnhnb.com/group1/M00/77/0A/7C853FD075ChRkRlkMKWCANndDAAISQvQX3GE408.jpg" />
	  </mt-swipe-item>
	  <mt-swipe-item>
	  	<img class="img" src="http://img.cnhnb.com/group1/M00/72/E8/BB8BB*H6D9ChRkRlj9dTaAdwcAAAGcu9tI7C8213.jpg" />
	  </mt-swipe-item>
	  <mt-swipe-item>
	  	<img class="img" src="http://img.cnhnb.com/group1/M00/72/E8/2FED61C20DChRkRlj9dTaAAXUWAAJF6ygP680344.jpg" />
	  </mt-swipe-item>
	  <mt-swipe-item>
	  	<img class="img" src="http://img.cnhnb.com/group1/M00/77/0A/7C853FD075ChRkRlkMKWCANndDAAISQvQX3GE408.jpg" />
	  </mt-swipe-item>

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
		height:400px;
	}
	#swiper .swiper-pagination-bullet {
		background: #e5e8e8;
		opacity: 1; 
	}
	#swiper .swiper-pagination-bullet-active {
		background: #ff5733;
	}
</style>