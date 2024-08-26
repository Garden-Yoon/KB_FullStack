<script setup>
// menu라는 props 정의, 타입은 객체, 필수 속성
// 부모 컴포넌트에서 받아올 데이터
const props = defineProps({
  menu: { Type: Object, required: true },
});
</script>

<template>
  <li class="nav-item">
    <router-link class="nav-link" :to="menu.url">
      <i :class="menu.icon"></i>
      <!-- {{ }} -> v-text : 데이터를 화면에 그대로 출력 -->
      <!-- v-html : 태그로 인식 -->
      {{ menu.title }}
    </router-link>
  </li>
</template>

<style></style>
