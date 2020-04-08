import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    count: 99,
    token: '2230'
  },

  mutations: {
    increment(state) {
      state.count++
    },
    setToken(state, token) {
      state.token = token
    }
  }
});
export default store
