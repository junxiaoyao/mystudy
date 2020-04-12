<template>
  <el-container>
    <el-header>
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1"><a href="/testComponent" target="mainContainer">测试列表</a></el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-submenu>
        <el-menu-item index="3" @click="loginVisible=true" v-show="!showUser">登录</el-menu-item>
        <el-dialog
          title="登录"
          :visible.sync="loginVisible"
          width="30%"
        >
          <Login @setUserName="setUserName">

          </Login>
        </el-dialog>
        <el-menu-item v-show="showUser">{{ user }}</el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      4
    </el-main>
    <el-footer>
    <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
  import Login from '@/views/Login'
  import TestComponent from '@/views/TestComponent'
  import Footer from '@/views/Footer'
  export default {
    name: "Index",
    mounted: function () {
      let token = localStorage.getItem("authentication");
      if (token) {
        console.log(this.user)
        //this.loginVisible=true,
        this.showUser = true
        this.user = "--------君逍遥----"
      }
    },
    data: function () {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        loginVisible: false,
        user: '未登录',
        showUser: false
      }
    },
    methods: {
      setUserName: function (name) {
        this.user = name
        this.showUser = true
        this.loginVisible = false
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    },
    components: {
      Login, TestComponent,Footer
    }
  }
</script>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;

  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 500px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 600px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
