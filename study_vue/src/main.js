// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import Api from './axios/index.js';
// import ListComponent from '@/views/ListComponent.vue'
Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.prototype.$api = Api;
/* eslint-disable no-new */


//路由构造测试
router.beforeEach((to, form, next) => {
//设置标题
  document.title = to.meta.title;
  if (to.meta.isToken) {
    if (!localStorage.getItem("authentication")) {
      router.push("/login")
    } else {
      next();
    }
  }
  next();
});


const vue = new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
});

