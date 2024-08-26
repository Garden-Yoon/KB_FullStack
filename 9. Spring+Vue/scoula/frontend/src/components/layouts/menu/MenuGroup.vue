<script setup>
import MenuItem from './MenuItem.vue';
// menus는 부모에게 받아오는 props
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>
<template>
  <ul class="navbar-nav">
    <!-- 부모에게 받아온 menus 배열을 돌면서 menu라는 이름으로 꺼내온다. -->
    <!-- 하나씩 꺼낸 menu 객체를 menu라는 props로 자식에게 전달한다 -->
    <MenuItem v-for="menu in menus" :menu="menu" />
  </ul>
</template>
