import Vue from 'vue';  
import Vuex from 'vuex';  
  
Vue.use(Vuex);  
  
const store = new Vuex.Store({  
  state: {  
    token: 0  
  },
  getter: {

  },
  mutations: {  
    setToken (token) {  
      state.count++;
    }  
  },  
  actions: {  
    increment ({ commit }) {  
      commit('increment');  
    }  
  }  
});