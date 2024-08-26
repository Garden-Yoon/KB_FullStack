// 인증과 관련된 라우트를 정의하는 js
export default [
  {
    // 로그인 페이지에 대한 라우트
    path: '/auth/login',
    name: 'login',
    component: () => import('../pages/auth/LoginPage.vue'),
  },
  {
    // 회원가입 페이지에 대한 라우트
    path: '/auth/join',
    name: 'join',
    component: () => import('../pages/auth/JoinPage.vue'),
  },
  {
    // 프로필 페이지에 대한 라우트
    path: '/auth/profile',
    name: 'profile',
    component: () => import('../pages/auth/ProfilePage.vue'),
  },
  {
    // 비밀번호 변경 페이지에 대한 라우트
    path: '/auth/changepassword',
    name: 'changepassword',
    component: () => import('../pages/auth/ChangePasswordPage.vue'),
  },
];
