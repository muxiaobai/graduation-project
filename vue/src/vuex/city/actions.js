import { UPDATECITY } from './type'
import { mapMutations } from 'vuex'
import { getGoodsListPage }from '../../services/api/api'
import Vue from 'vue'
export default {
  updateCityAsync ({ commit, state }, {city}) {
  	if (!city.name) {
  		city.name = state.name
  		city.rN = state.rN
  	}
    return  getGoodsListPage().then(res =>{
      let data = res.data;
      let lists = data.data.content;
      //模拟索引数据的id号
      lists.forEach((item, index) => {
        item.mID = index  
      })
  		city.data  = lists
  		commit(UPDATECITY, { city })
    });
  }
}
