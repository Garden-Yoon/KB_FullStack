<template>
  <div>
    <!-- 기존 코드와 달리 각각의 컴포넌트 스타일이 적용됨 -->
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>

<script>
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';

export default {
  name: 'App',
  components: { Child1, Child2, Child3 },
};
</script>
