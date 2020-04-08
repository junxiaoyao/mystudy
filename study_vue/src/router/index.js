import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Test from '@/components/Test'
import Login from '@/views/Login'
import Test_view from '@/views/Test_view'
import ComList from '@/views/ComList'
import TestComponent from '@/views/TestComponent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      meta: {
        title: 'HelloWorld',
        isToken: false
      },
      component: HelloWorld
    },
    {
      path: '/testComponent',
      name: 'TestComponent',
      meta: {
        title: '组件调用测试',
        isToken: true
      },
      component: TestComponent
    },
    {
      path: '/test',
      name: 'test',
      // eslint-disable-next-line no-undef
      meta: {
        title: '测试',
        isToken: false
      },
      component: Test
    },
    {
      path: '/login',
      name: 'login',
      meta: {
        title: '登录',
        isToken: false
      },
      // eslint-disable-next-line no-undef
      component: Login
    },
    {
      path: '/test_view',
      name: 'Test_view',
      meta: {
        title: '测试视图',
        isToken: false
      },
      // eslint-disable-next-line no-undef
      component: Test_view
    },
    {
      path: '/com',
      name: 'com',
      meta: {
        title: '社团列表',
        isToken: false
      },
      // eslint-disable-next-line no-undef
      component: ComList
    }
  ],
  mode: 'history'
})
