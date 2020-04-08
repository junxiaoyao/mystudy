import axios from 'axios';
import store from '.././store'
import Cookies from 'js-cookie'

let http = axios.create({
  baseURL: 'http://localhost:8083/',
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
    //'authorization':''
  },
  transformRequest: [function (data) {
    let newData = '';
    for (let k in data) {
      if (data.hasOwnProperty(k) === true) {
        newData += encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) + '&';
      }
    }
    return newData;
  }]
});
http.interceptors.request.use(config => {
    //const token = Cookies.get("authorization");
  let token=localStorage.getItem("authentication")
    // console.log("--------------")
    // console.log(config)
    // console.log(token)
    // console.log("------------------")
    if (token) {
      config.headers.authentication = token
    }
    return config
  },
  error => {
    return Promise.reject(err)
  }
);
//http response 拦截器
axios.interceptors.response.use(response => {
  // if (response.data.errCode == 2) {
  //   router.push({
  //     path: '/login',
  //     querry: {
  //       redirect: router.currentRoute.fullPath
  //     } //从哪个页面跳转
  //   });
  // }
  return response;
}, error => {
  return Promise.reject(error);
});

//  function setAxios(){
//   //请求拦截
//   axios.interceptors.request.use(
//     config=>{
//       if(store.state.token){
//         config.headers.token=store.state.token
//       }
//       return config
//     }
//   )
//   //每次请求有返回的，都是先警告拦截器最先的
//   axios.interceptors.response.use(
//     response=>{
//       if(response.status==200){
//         const data=response.data
//         if(data.code==-1){
//           //登录过期 需求重新登录 情况vuex的token和localstorge的token
//           store.commit('settoken','')
//           localStorage.removeItem('token')
//           //调转到login界面
//           router.replace({path:'/login'})
//         }
//         return data
//       }
//       return response
//     }
//   )
// }
function apiAxios(method, url, params, response) {
  //console.log(store._vm.$data.$$state.token)
  http({
    method: method,
    url: url,
    data: method === 'POST' || method === 'PUT' ? params : null,
    params: method === 'GET' || method === 'DELETE' ? params : null,
  }).then(function (res) {
    response(res);
  }).catch(function (err) {
    response(err);
  })
}

export default {
  get: function (url, params, response) {
    return apiAxios('GET', url, params, response)
  },
  post: function (url, params, response) {
    return apiAxios('POST', url, params, response)
  },
  put: function (url, params, response) {
    return apiAxios('PUT', url, params, response)
  },
  delete: function (url, params, response) {
    return apiAxios('DELETE', url, params, response)
  }
}
