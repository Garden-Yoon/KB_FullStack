// 게시판 관련한 라우트를 정의하는 js
export default [
  {
    // 게시판 리스트 페이지에 대한 라우트
    path: '/board/list',
    name: 'board/list',
    component: () => import('../pages/board/BoardListPage.vue'),
  },
];
