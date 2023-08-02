import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuetify from './plugins/vuetify';

Vue.config.productionTip = false
// Insertar luego de la siguiente línea
// Instancia de axios se configura con URL base del backend
const axiosInstance = axios.create({
  baseURL: "http://localhost:9090"
  })
// Para acceder a axios desde this.$http
Vue.prototype.$http = axiosInstance

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')