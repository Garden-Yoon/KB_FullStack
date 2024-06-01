<template>
  <div>
    <SlotTest />
    <namedSlotTest />
  </div>
</template>

<script>
// import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';
export default {
  name: 'App',
  // components: { SlotTest, NamedSlotTest },

  components: { NamedSlotTest },
};
</script>
