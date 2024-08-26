// 갤러리 관련한 라우트를 정의하는 js
export default [
  {
    // 갤러리 리스트 페이지에 대한 라우트
    path: '/gallery/list',
    name: 'gallery/list',
    component: () => import('../pages/gallery/GalleryListPage.vue'),
  },
];
