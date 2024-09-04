import { isAuthenticated } from '@/util/guards';

// 게시판 관련한 라우트를 정의하는 js
export default [
  {
    // 게시판 리스트 페이지에 대한 라우트
    path: '/board/list',
    name: 'board/list',
    component: () => import('../pages/board/BoardListPage.vue'),
  },

  {
    // 게시판 상세 페이지에 대한 라우트 (:no 는 바뀌는 변수 부분)
    path: '/board/detail/:no',
    name: 'board/detail',
    component: () => import('../pages/board/BoardDetailPage.vue'),
  },

  {
    // 게시판 작성 페이지에 대한 라우트
    path: '/board/create',
    name: 'board/create',
    component: () => import('../pages/board/BoardCreatePage.vue'),
    // 라우트 접근 전에 인증 여부 확인
    beforeEnter: isAuthenticated,
  },
  {
    // 게시판 수정 페이지에 대한 라우트 (:no 는 바뀌는 변수 부분)
    path: '/board/update/:no',
    name: 'board/update',
    component: () => import('../pages/board/BoardUpdatePage.vue'),
    // 라우트 접근 전에 인증 여부 확인
    beforeEnter: isAuthenticated,
  },
];
