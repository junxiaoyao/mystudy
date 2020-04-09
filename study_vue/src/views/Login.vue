<template>
  <el-row>
    <el-col :span="4">
      <div class="grid-content bg-purple"></div>
    </el-col>
    <el-col :span="16">
      <div class="grid-content bg-purple-light">
        <el-col :span="24">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="用户名">
              <el-input v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item >
              <el-button type="primary" @click="onSubmit" round>登录</el-button>
              <el-button type="success" round>注册</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </div>
    </el-col>
    <el-col :span="4">

    </el-col>
  </el-row>

</template>

<script>
  import Cookies from 'js-cookie'

  export default {
    data() {
      return {
        form: {
          userName: 'user',
          password: '123456',
        }
      }
    },
    methods: {
      onSubmit() {
        this.$api.post('/login', this.form, response => {
          console.log(this.$store.state.token);
          if (response.status >= 200 && response.status < 300) {
            console.log(response);
            localStorage.setItem("authentication", response.data.data)
            Cookies.set("authentication", response.data.data)
            this.$store.commit('setToken', response.data.data);
            this.$emit('setUserName','君逍遥')
            //this.$router.push('/testComponent')
            // console.log(this.$store.state.token);
            // this.$store.state.token = response.data.data
            // console.log(this.$store.state.token);
            // this.$api.http.defaults.headers.common['token'] = token;
          } else {
            console.log(response);
          }
        });
      }
    }
  }
</script>

<style scoped>

</style>
