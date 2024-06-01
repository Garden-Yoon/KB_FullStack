<template>
  <div>
    <SlotTest />
  </div>
</template>

<script>
import SlotTest from './components/SlotTest.vue';
export default {
  name: 'App',
  components: { SlotTest },
};
</script>
