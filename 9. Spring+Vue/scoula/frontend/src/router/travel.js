// 여행 관련한 라우트를 정의하는 js
export default [
  {
    // 여행 리스트 페이지에 대한 라우트
    path: '/travel/list',
    name: 'travel/list',
    component: () => import('../pages/travel/TravelListPage.vue'),
  },
];
