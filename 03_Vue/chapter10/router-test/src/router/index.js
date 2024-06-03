import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // 무조건 로딩되어야하는 페이지기 때문에 정적으로 처리
  routes: [
    { path: '/', component: Home },
    { path: '/about', component: About },
    { path: '/members', component: Members },
    { path: '/videos', component: Videos },
    // 어떤 문자든지 위에서 해당하지 않는 경로는 다 여기서 처리함 (404 라우터)
    { path: '/:paths(.*)*', name: 'NotFound', component: NotFound },
  ],
});

export default router;
