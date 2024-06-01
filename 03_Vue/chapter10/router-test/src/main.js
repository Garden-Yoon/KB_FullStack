import { createApp } from 'vue';
import 'bootstrap/dist/css/bootstrap.css';
import App from './App.vue';
import router from './router';

const app = createApp(App);

// 해당 앱에서 라우터 사용하겠다고 명시
app.use(router);

app.mount('#app');
