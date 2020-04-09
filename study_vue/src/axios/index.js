import axios from 'axios';
import store from '.././store'
import Cookies from 'js-cookie'
import router from '.././router'
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
http.interceptors.response.use(response => {
  //token过期
  if (response.data.code === 401) {
    router.push("/login")
  }
  // console.log(response)
  return response;
}, error => {
  return Promise.reject(error);
});

function apiAxios(method, url, params, response) {
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
