<script setup>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
</script>

<template>
  <!-- 자식 컴포넌트에게 RouterView를 전달한다 -->
  <DefaultLayout>
    <!-- RouterView : 갈아끼우는 용도의 뷰를 넣는다 -->
    <RouterView />
  </DefaultLayout>
</template>

<!-- scoped : 해당 뷰에서만 사용할 스타일 범위 -->
<style scoped></style>
