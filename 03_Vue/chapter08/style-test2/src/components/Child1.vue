<template>
  <div class="child">
    <h2>Child1</h2>
  </div>
</template>

<script>
export default {
  name: 'Child1',
};
</script>

<style scoped>
.child {
  background-color: yellow;
  border: solid 1px black;
  /* em은 부모요소의 몇배수 */
  margin: 1.5em;
  padding: 1em;
}
</style>
