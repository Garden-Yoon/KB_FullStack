<template>
  <div class="container">
    <!-- Header처럼 변하지않고 고정된 부분은 components 폴더에 생성 -->
    <Header />
    <!-- router-view 처럼 동적으로 변하는 페이지들은 pages 폴더에 생성 -->
    <router-view></router-view>
  </div>
</template>

<script>
import Header from '@/components/Header.vue';

// components 폴더 내에 있는 컴포넌트들만 등록하면 된다
export default {
  name: 'App',
  components: { Header },
};
</script>
<style>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
