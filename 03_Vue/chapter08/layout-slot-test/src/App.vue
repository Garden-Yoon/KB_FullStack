<template>
  <Layout>
    <!-- slot을 전달해줄때는 무조건 자식 컴포넌트의 사이에 넣어준다 -->
    <template v-slot:header>
      <h2>헤더 영역</h2>
    </template>
    <template v-slot:sidebar>
      <h2>사이드</h2>
    </template>
    <template v-slot:default>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
    </template>
    <template v-slot:footer>
      <h2>헤더 영역</h2>
    </template>
  </Layout>
</template>

<script>
import Layout from './components/Layout.vue';

export default {
  name: 'App',
  components: { Layout },
};
</script>
