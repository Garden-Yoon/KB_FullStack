<template>
  <div style="border: solid 1x gray; padding: 5px"></div>
</template>
<script>
export default {
  name: 'CheckboxItem',
  //props : 부모 컴퍼넌트 (App.vue)한테 받아온 속성
  props: ['name', 'checked'],
};
</script>
